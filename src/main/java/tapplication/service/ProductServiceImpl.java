package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.ParametersDto;
import tapplication.dto.ProductAndAmount;
import tapplication.dto.ProductDto;
import tapplication.dto.ProductImageDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.*;
import tapplication.repositories.BrandDao;
import tapplication.repositories.CategoryDao;
import tapplication.repositories.ProductDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ParametersServiceImpl parametersService;
    @Autowired
    private WebApiService webApiService;


    Logger logger = LoggerFactory.getLogger(getClass());

    public ProductDto create(ProductDto newProduct) {
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

    public void update(ProductDto productDto) {
        Product product = productDao.findOne(productDto.getId());

        Map<Long, ParametersDto> parMap = productDto.getParameters().stream().collect(Collectors.toMap(ParametersDto::getId, par -> par));

        product.getParameters().forEach(par -> {
            par.setQuantity(parMap.get(par.getId()).getQuantity());
            par.setWeight(parMap.get(par.getId()).getWeight());
        });

        Map<Long, ProductImageDto> imgMap = productDto.getImages().stream().collect(Collectors.toMap(ProductImageDto::getId, img -> img));
        product.getImages().forEach(img ->{
            img.setImage(imgMap.get(img.getId()).getUrl());
            img.setName(imgMap.get(img.getId()).getName());
        });

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setModel(productDto.getModel());
        product.setDescription(productDto.getDescription());
        product.setChangeDate(new Date());
        productDao.merge(product);

        webApiService.update(productDto);

        logger.info("Product id{} is updated.", product.getId());
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
                logger.warn("Product id:{} and size{} : quantity:{} is less then requested:{}", productId, size, p.getQuantity(), quantity);
                throw new PlaceToOrderException("Product model: " + product.getModel() + " size:" + p.getSize() + " is less then requested. Available now: " + p.getQuantity(), HttpStatus.NOT_FOUND);
            } else {
                p.setQuantity(p.getQuantity() - quantity);
                logger.info("Product id:{},size:{},quantity:{} moved to order.", productId, size, quantity);
            }
        });
        return product;
    }

    public void moveFromExpiredOrder(Product product, Long quantity, String size) {

        product.getParameters().stream()
                .filter(par -> par.getSize().equals(size))
                .forEach(par -> par.setQuantity(par.getQuantity() + quantity));
        productDao.merge(product);
        logger.info("{} Product {} quantity {} moved back to Product", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), product.getId(), quantity);
    }

    public List<ProductDto> getProducts(List<ProductAndAmount> productAndAmounts) {
        return productAndAmounts.stream()
                .map(entry -> new ProductDto(productDao.findOne(entry.getProductId()), entry.getCount(), entry.getSize()))
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

    private void addNewParameters(ProductDto newProduct) {
        Product product = productDao.findOneByAndParams(Product.MODEL, newProduct.getModel());
        ParametersDto parametersDto = newProduct.getParameters().get(0);

        parametersDto.setProductId(product.getId());
        parametersService.add(parametersDto);
        logger.info("New parameters: size:{},quantity:{},weight:{} added for Product id:{}.",
                parametersDto.getSize(),
                parametersDto.getQuantity(),
                parametersDto.getWeight(),
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
        product.setPrice(newProduct.getPrice());
        product.setDescription(newProduct.getDescription());
        product.setChangeDate(new Date());

        productDao.persist(product);

        product.getImages().forEach(item -> item.setProduct(product));
        product.getCategory().getProducts().add(product.getId());
        product.getParameters().forEach(item -> item.setProduct(product));
        newProduct.setId(product.getId());
        logger.info("Product id{} has been created.", product.getId());
    }


}