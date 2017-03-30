package tapplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.product.brand.Brand;
import tapplication.product.category.Category;
import tapplication.product.parameters.Parameters;
import tapplication.product.productImage.ProductImage;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.Date;
import java.util.List;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product create(Brand brand, String name, String model, String color, String description, Long price, Long quantity, Date changeDate, List<Category> categories, List<ProductImage> images, List<Parameters> parameters) throws NonUniqueResultException {
        Product product;

        try {
            product = productDao.getProductIfExist(brand.getName(), model, color);
        } catch (NoResultException e) {
            product = new Product(brand, name, model, color, description, price, quantity, changeDate, categories, images, parameters);
            productDao.persist(product);
        }
        product.increaseQuantity(quantity);
        productDao.merge(product);
        return product;
    }
}
