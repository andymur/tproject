package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.AdProduct;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Repository
public class AdProductDao extends AbstractDao<AdProduct, Long>{
    public AdProductDao() {
        super(AdProduct.class);
    }
}
