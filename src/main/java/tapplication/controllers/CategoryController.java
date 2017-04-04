package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Category;
import tapplication.service.CategoryServiceImpl;

/**
 * Created by alexpench on 31.03.17.
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "category/create/", method = RequestMethod.POST)
    public Object create(@RequestBody Category newCategory) throws AlreadyExistException {
        Category category = categoryService.create(newCategory);
        return category;
    }

    @RequestMapping(value = "category")
    public Object findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "category/update", method = RequestMethod.POST)
    public Object update(@RequestBody Category category) throws NotFoundException {
        return categoryService.update(category);
    }

    @RequestMapping(value = "category/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Category category) throws NotFoundException {
        categoryService.delete(category);
    }

}
