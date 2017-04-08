package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.Product;
import tapplication.repositories.ProductDao;

import java.util.List;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
public class ProductService implements CoreService<Product> {
    @Autowired
    private ProductDao productDao;

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

    public List<Product> getProductsByCategoryId(Long categoryId) throws NotFoundException {
        List<Product> products = findAllByCategory(categoryId);
//        products.forEach(p->{p.getImages();p.getParameters();});
        return products;
    }

    public List<Product> findAllByParams(Long categoryId, String brand, String color, String size) {
        return productDao.findByParams(categoryId, brand, color, size);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Product findOne(Long productId) throws NotFoundException {
        Product product = productDao.findOne(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Product moveToOrder(Long productId, Long quantity) throws NotFoundException, PlaceToOrderException {
        Product product = findOne(productId);
        if(product.getQuantity() < quantity){
            throw new PlaceToOrderException();
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            productDao.merge(product);
        }
        return product;
    }
}
