package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Product;
import tapplication.repositories.ProductDao;

import java.util.List;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product create(final Product newProduct) throws AlreadyExistException {

        if (productDao.isProductExist(newProduct.getBrand().getName(), newProduct.getModel(), newProduct.getColor())) {
            throw new AlreadyExistException();
        }
        productDao.persist(newProduct);
//        newProduct.getBrand().setProduct(newProduct);
        newProduct.getImages().forEach(item -> item.setProduct(newProduct));
        newProduct.getCategory().getProducts().add(newProduct.getId());
        newProduct.getParameters().forEach(item -> item.setProduct(newProduct));
        return newProduct;
    }

    public List<Product> findAll() {
        return productDao.selectAll();
    }

    public List<Product> findAllByCategory(Long categoryId) {
        return productDao.find(Product.PRODUCT_CATEGORY, categoryId);

    }

    @Transactional
    public List<Product> getProductsByCategoryId(Long categoryId) throws NotFoundException {
        List<Product> products = findAllByCategory(categoryId);
//        products.forEach(p->{p.getImages();p.getParameters();});
        return products;
    }

    public List<Product> findAllByParams(Long categoryId, String brand, String color, String size) {
        return productDao.findByParams(categoryId,brand,color,size);
    }
}
