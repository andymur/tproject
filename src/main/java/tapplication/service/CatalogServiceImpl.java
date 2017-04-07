package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Product;

import java.util.List;

/**
 * Created by alexpench on 04.04.17.
 */
@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private ProductService productService;

    public List<Product> getProductsByCategoryId(Long categoryId) throws NotFoundException {
        List<Product> products = productService.findAllByCategory(categoryId);
        products.forEach(p->{p.getImages();p.getParameters();});
        return products;
    }
}
