package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Category;

/**
 * Created by alexpench on 04.04.17.
 */
@Service("catalogService")
public class CatalogServiceImpl implements Catalogervice {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Override
    public Object preparePage(Model model, Long categoryId) throws NotFoundException {
        Category category = categoryService.findOne(categoryId);
        category.getProducts();
        return null;
    }
}
