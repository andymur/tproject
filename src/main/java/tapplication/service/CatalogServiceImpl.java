package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Product;

import java.util.List;

/**
 * Created by alexpench on 04.04.17.
 */
@Service("catalogService")
public class CatalogServiceImpl implements Catalogervice {
    @Autowired
    private ProductService productService;

    @Transactional
    public List<Product> getProductsByCategoryId(Long categoryId) throws NotFoundException {
        List<Product> products = productService.findAllByCategory(categoryId);
        products.forEach(p->{p.getImages();p.getParameters();});
        return products;
    }
}
