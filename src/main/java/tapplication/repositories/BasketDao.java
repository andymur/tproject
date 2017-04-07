package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.BasketProduct;

/**
 * Created by alexpench on 06.04.17.
 */
@Repository
public class BasketDao extends AbstractDao<BasketProduct, Long> {

    public BasketDao() {
        super(BasketProduct.class);
    }

}
