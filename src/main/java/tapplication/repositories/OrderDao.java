package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Order;
import tapplication.service.OrderStatusCode;
import tapplication.service.PaymentTypeCode;

import javax.ejb.Local;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexpench on 07.04.17.
 */
@Repository
public class OrderDao extends AbstractDao<Order, Long> {
    public OrderDao() {
        super(Order.class);
    }

    public List<Order> findAllExpired() {
        CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        List<Predicate> predList = new LinkedList<>();
        predList.add(criteriaBuilder.and(criteriaBuilder.lessThan(order.get("orderDate"), new Date (System.currentTimeMillis() - 15 * 60 * 1000))));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get("orderStatus"), OrderStatusCode.AWAIT_PAYMENT.ordinal())));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get("paymentType"), PaymentTypeCode.CARD.ordinal())));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);
        return find(query);

    }
}

//LocalDateTime.now().minusMinutes(15L)
