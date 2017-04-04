package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Category;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by alexpench on 31.03.17.
 */
@Repository
public class CategoryDao extends AbstractDao<Category, Long> {

    public CategoryDao() {
        super(Category.class);
    }
    public List<Category> findAll(){
        Query query = super.getEntityManager().createQuery(
                "Select c from Category c ");
        return query.getResultList();

    }
    public boolean isExist(String categoryName) {
        return count(Category.NAME, categoryName) != 0;
    }
}
