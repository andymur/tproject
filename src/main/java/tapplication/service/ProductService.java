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
import tapplication.model.Product;
import tapplication.repositories.ProductDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductService implements CoreService<Product> {
    @Autowired
    private ProductDao productDao;

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

    public List<ProductDto> getProductsByCategoryId(Long categoryId) throws NotFoundException {
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
        products.forEach(pr -> pr.getParameters().forEach(par -> sizes.addAll(par.getSizes())));
        return sizes;
    }


}