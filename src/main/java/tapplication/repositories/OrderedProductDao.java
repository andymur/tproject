package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.service.OrderStatusCode;

import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
@Repository
public class OrderedProductDao extends AbstractDao<OrderedProduct, Long> {

    private static final String ORDER = "order";
    private static final String QUANTITY = "quantity";
    public static final String PRODUCT = "product";
    private static final String ORDER_STATUS = "orderStatus";

    public OrderedProductDao() {
        super(OrderedProduct.class);
    }

    public List<OrderedProduct> findTopProducts(int count) {
        CriteriaBuilder cb = super.getCriteriaBuilder();
        CriteriaQuery<OrderedProduct> q = cb.createQuery(OrderedProduct.class);
        Root<OrderedProduct> p = q.from(OrderedProduct.class);
        Join<OrderedProduct, Order> order = p.join(ORDER);
        q.multiselect(p.get(PRODUCT), cb.sum(p.get(QUANTITY)));
        q.groupBy(p.get(PRODUCT));

        List<Predicate> predList = new LinkedList<>();
        predList.add(cb.and(cb.notEqual(order.get(ORDER_STATUS), OrderStatusCode.EXPIRED.ordinal())));
        predList.add(cb.or(cb.notEqual(order.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));

        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        q.where(predArray);
        return super.getEntityManager().createQuery(q).setMaxResults(count).getResultList();
    }

}
