package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Order;
import tapplication.service.OrderStatusCode;
import tapplication.service.PaymentTypeCode;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexpench on 07.04.17.
 */
@Repository
public class OrderDao extends AbstractDao<Order, Long> {

    public static final String ORDER_DATE = "orderDate";
    public static final String ORDER_STATUS = "orderStatus";
    public static final String PAYMENT_TYPE = "paymentType";

    public OrderDao() {
        super(Order.class);
    }

    public List<Order> findAllExpired() {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        List<Predicate> predList = new LinkedList<>();
        predList.add(criteriaBuilder.and(criteriaBuilder.lessThan(order.get(ORDER_DATE), new Date (System.currentTimeMillis() - 15 * 60 * 1000))));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get(PAYMENT_TYPE), PaymentTypeCode.CARD.ordinal())));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);
        return find(query);

    }
}