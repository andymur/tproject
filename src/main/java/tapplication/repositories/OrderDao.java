package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Order;

/**
 * Created by alexpench on 07.04.17.
 */
@Repository
public class OrderDao extends AbstractDao<Order, Long>{
    public OrderDao() {
        super(Order.class);
    }
}
