package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Brand;

/**
 * Created by alexpench on 30.03.17.
 */
@Repository
public class BrandDao extends AbstractDao<Brand, Long> {

    public BrandDao() {
        super(Brand.class);
    }

    public boolean isBrandExist(String brandName) {
        return count(Brand.NAME, brandName) != 0;
    }

}
