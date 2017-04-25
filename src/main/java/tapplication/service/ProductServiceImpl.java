package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.ProductAndAmount;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.*;
import tapplication.repositories.BrandDao;
import tapplication.repositories.CategoryDao;
import tapplication.repositories.ProductDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ParametersServiceImpl parametersService;

    Logger logger = LoggerFactory.getLogger(getClass());

    public ProductDto create(final ProductDto newProduct) {
        if (productDao.isProductExistWithSameSize(newProduct)) {
            logger.warn("Product already exist");
            throw new AlreadyExistException();
        } else if (productDao.isNewSizeForExistingProduct(newProduct)) {
            addNewParameters(newProduct);
        } else {
            createIfTotallyNew(newProduct);
        }
        return newProduct;
    }

    private void addNewParameters(ProductDto newProduct) {
        Product product = productDao.findOneByAndParams(Product.MODEL, newProduct.getModel());
        parametersService.create(newProduct.getParameters().get(0), product);
        product.setQuantity(product.getQuantity() + newProduct.getQuantity());
        logger.info("New parameters: size:{},quantity:{},weight:{} added for Product id:{}.",
                newProduct.getParameters().get(0).getSize(),
                newProduct.getParameters().get(0).getQuantity(),
                newProduct.getParameters().get(0).getWeight(),
                product.getId());
    }

    private void createIfTotallyNew(ProductDto newProduct) {
        Product product = new Product();

        product.setBrand(brandDao.findOne(Brand.NAME, newProduct.getBrand()));
        product.setCategory(categoryDao.findOne(Category.NAME, newProduct.getCategory()));
        product.setName(newProduct.getName());
        product.setModel(newProduct.getModel());
        product.setColor(newProduct.getColor());
        product.setImages(newProduct.getImages().stream().map(i -> new ProductImage(i.getName(), i.getUrl())).collect(Collectors.toList()));
        product.setParameters(newProduct.getParameters().stream().map(p -> new Parameters(p.getSize(), p.getWeight(), p.getQuantity())).collect(Collectors.toList()));
        product.setQuantity(newProduct.getQuantity());
        product.setPrice(newProduct.getPrice());
        product.setDescription(newProduct.getDescription());
        product.setChangeDate(new Date());

        productDao.persist(product);

        product.getImages().forEach(item -> item.setProduct(product));
        product.getCategory().getProducts().add(product.getId());
        product.getParameters().forEach(item -> item.setProduct(product));
        newProduct.setProductId(product.getId());
        logger.info("Product id{} has been created.",product.getId());
    }

    public void update(ProductDto productDto) {
        Product product = productDao.findOne(productDto.getProductId());
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setModel(productDto.getModel());
        product.setDescription(productDto.getDescription());
        product.setChangeDate(new Date());
        productDao.merge(product);
        logger.info("Product id{} is updated.",product.getId());
    }

    public List<Product> findAll() {
        return productDao.selectAll();
    }

    public List<Product> findAllByCategory(Long categoryId) {
        return productDao.find(Product.PRODUCT_CATEGORY, categoryId);

    }

    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        List<Product> products = findAllByCategory(categoryId);
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsDtoList() {
        List<Product> products = productDao.selectAll();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public List<ProductDto> findAllByParams(Long categoryId, String brand, String color, String size) {
        List<Product> products = productDao.findByParams(categoryId, brand, color, size);
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Product findOne(Long productId) {
        Product product = productDao.findOne(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    public ProductDto findOneDto(Long productId) {
        Product product = productDao.findOne(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return new ProductDto(product);
    }

    public Product moveToOrder(Long productId, Long quantity, String size) {
        Product product = findOne(productId);

        product.getParameters().stream().filter(p -> p.getSize().equals(size)).forEach(p -> {
            if (p.getQuantity() < quantity) {
                logger.warn("Product id:{} and size{} : quantity:{} is less then requested:{}",productId,size,p.getQuantity(),quantity);
                throw new PlaceToOrderException("Product model: " + product.getModel() + " size:"+p.getSize() +" is less then requested. Available now: " + p.getQuantity(), HttpStatus.NOT_FOUND);
            } else {
                p.setQuantity(p.getQuantity() - quantity);
                product.setQuantity(product.getQuantity() - quantity);
             logger.info("Product id:{},size:{},quantity:{} moved to order.",productId,size,quantity);
            }
        });
        return product;
    }

    public void moveFromExpiredOrder(Product product, Long quantity) {
        product.setQuantity(product.getQuantity() + quantity);
        productDao.merge(product);
        logger.info("{} Product {} quantity {} moved back to Product", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), product.getId(), quantity);
    }

    public List<ProductDto> getProductsForOrder(List<ProductAndAmount> productAndAmounts) {
        return productAndAmounts.stream()
                .map(entry -> new ProductDto(productDao.findOne(entry.getProductId()), entry.getCount(), entry.getSize()))
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsForBasket(List<ProductAndAmount> productsAndAmount) {
        return productsAndAmount.stream()
                .map(p -> new ProductDto(productDao.findOne(p.getProductId()), p.getCount(), p.getSize()))
                .collect(Collectors.toList());
    }

    public Set<String> getColors(List<ProductDto> products) {
        Set<String> colors = new HashSet<>();
        products.forEach(pr -> colors.add(pr.getColor()));
        return colors;
    }

    public Set<String> getBrands(List<ProductDto> products) {
        Set<String> brands = new HashSet<>();
        products.forEach(pr -> brands.add(pr.getBrand()));
        return brands;
    }

    public Set<String> getSizes(List<ProductDto> products) {
        Set<String> sizes = new HashSet<>();
        products.forEach(pr -> pr.getParameters().forEach(par -> sizes.add(par.getSize())));
        return sizes;
    }


}