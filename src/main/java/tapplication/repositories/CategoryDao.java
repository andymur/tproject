package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Category;

/**
 * Created by alexpench on 31.03.17.
 */
@Repository
public class CategoryDao extends AbstractDao<Category, Long> {

    public CategoryDao() {
        super(Category.class);
    }
    public boolean isExist(String categoryName) {
        return count(Category.NAME, categoryName) != 0;
    }
}
