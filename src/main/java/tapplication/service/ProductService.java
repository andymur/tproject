package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Product;
import tapplication.repositories.ProductDao;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public Product create(Product newProduct) throws AlreadyExistException {

        if (productDao.isProductExist(newProduct.getBrand().getName(), newProduct.getModel(), newProduct.getColor())) {
            throw new AlreadyExistException();
        }
        productDao.persist(newProduct);
        return newProduct;
    }
}
