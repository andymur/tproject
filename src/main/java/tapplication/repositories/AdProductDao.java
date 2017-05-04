package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.AdProduct;
import tapplication.model.Product;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Repository
public class AdProductDao extends AbstractDao<AdProduct, Long>{

    public static final String PRODUCT = "product";

    public AdProductDao() {
        super(AdProduct.class);
    }

    public boolean isExist(Product product){
        return super.count(PRODUCT, product) != 0;
    }
}
