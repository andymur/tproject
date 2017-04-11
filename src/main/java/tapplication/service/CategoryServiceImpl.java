package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.controllers.dto.CategoryDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Category;
import tapplication.repositories.CategoryDao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 31.03.17.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CoreService<Category> {
    @Autowired
    private CategoryDao categoryDao;

    public Category findOne(Long id) throws NotFoundException {
        return categoryDao.findOne(id);
    }

    public CategoryDto getCategoryDtoById(Long id){
        return new CategoryDto(categoryDao.findOne(id));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Category create(Category category) throws AlreadyExistException {
        if (categoryDao.isExist(category.getName())) {
            throw new AlreadyExistException();
        }
        categoryDao.persist(category);
        return category;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Category update(Category category) throws NotFoundException {
        Category categoryToBeMerged = categoryDao.findOne(category.getId());
        if (categoryToBeMerged != null) {
            categoryDao.merge(category);
        } else {
            throw new NotFoundException();
        }
        return category;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Category category) throws NotFoundException {
        Category categoryToBeDeleted = categoryDao.findOne(category.getId());
        if (categoryToBeDeleted != null) {
            categoryDao.delete(categoryToBeDeleted);
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Map<Category, Integer> getCategoryMap() {
        List<Category> categories = categoryDao.findAll();
        Map<Category, Integer> categoryIntegerMap = categories.stream().collect(
                Collectors.toMap(cat -> cat, cat -> cat.getProducts().size()));
        return categoryIntegerMap;
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}


