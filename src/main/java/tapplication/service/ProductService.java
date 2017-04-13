package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.BasketDto;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.Brand;
import tapplication.model.Product;
import tapplication.repositories.ProductDao;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductService implements CoreService<Product> {
    @Autowired
    private ProductDao productDao;
    private Set<String> colors = new HashSet<>();
    private Set<Brand> brands = new HashSet<>();
    private Set<String> sizes = new HashSet<>();
//    List<ProductDto> productDtoList = new ArrayList<>();

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Product create(final Product newProduct) throws AlreadyExistException {

        if (productDao.isProductExist(newProduct.getBrand().getName(), newProduct.getModel(), newProduct.getColor())) {//TODO:change to Product product
            throw new AlreadyExistException();
        }
        productDao.persist(newProduct);
        newProduct.getImages().forEach(item -> item.setProduct(newProduct));
        newProduct.getCategory().getProducts().add(newProduct.getId());
        newProduct.getParameters().forEach(item -> item.setProduct(newProduct));
        return newProduct;
    }

    @Override
    public Product update(Product entity) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(Product entity) throws NotFoundException {

    }

    public List<Product> findAll() {
        return productDao.selectAll();
    }

    public List<Product> findAllByCategory(Long categoryId) {
        return productDao.find(Product.PRODUCT_CATEGORY, categoryId);

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<ProductDto> getProductsByCategoryId(Long categoryId) throws NotFoundException {
        List<Product> products = findAllByCategory(categoryId);
        colors.clear();
        brands.clear();
        sizes.clear();
        products.forEach(pr -> pr.getParameters().forEach(par -> sizes.add(par.getSize())));
        products.forEach(pr -> colors.add(pr.getColor()));
        products.forEach(pr -> brands.add(pr.getBrand()));
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

    public Product findOne(Long productId) throws NotFoundException {
        Product product = productDao.findOne(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    public Product moveToOrder(Long productId, Long quantity) throws NotFoundException, PlaceToOrderException {
        Product product = findOne(productId);
        if (product.getQuantity() < quantity) {
            throw new PlaceToOrderException();
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            productDao.merge(product);
        }
        return product;
    }

    public  List<ProductDto> getProductsForBasket(BasketDto basketDto) {
        return basketDto.getRows().stream()
                .map(entry-> new ProductDto(productDao.findOne(entry.getProductId()), entry.getCount()))
                .collect(Collectors.toList());
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Set<String> getColors() {
        return colors;
    }

    public void setColors(Set<String> colors) {
        this.colors = colors;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<String> getSizes() {
        return sizes;
    }

    public void setSizes(Set<String> sizes) {
        this.sizes = sizes;
    }

}