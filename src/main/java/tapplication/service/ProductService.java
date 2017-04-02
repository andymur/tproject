package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Product;
import tapplication.repositories.CategoryDao;
import tapplication.repositories.ParametersDao;
import tapplication.repositories.ProductDao;
import tapplication.repositories.ProductImageDao;

/**
 * Created by alexpench on 29.03.17.
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ParametersDao parametersDao;
    @Autowired
    private ProductImageDao productImageDao;
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public Product create(final Product newProduct) throws AlreadyExistException {

        if (productDao.isProductExist(newProduct.getBrand().getName(), newProduct.getModel(), newProduct.getColor())) {
            throw new AlreadyExistException();
        }
        productDao.persist(newProduct);
        newProduct.getBrand().setProduct(newProduct);
        newProduct.getImages().forEach(item->item.setProduct(newProduct));
        newProduct.getCategories().forEach(item->item.setProducts(newProduct));
        newProduct.getParameters().forEach(item->item.setProduct(newProduct));
        return newProduct;
    }
}
