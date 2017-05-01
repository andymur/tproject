package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Order;
import tapplication.service.DateUtil;
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
    public static final String USER = "user";

    public OrderDao() {
        super(Order.class);
    }

    public List<Order> findAllExpired() {
        CriteriaBuilder criteriaBuilder = super.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> order = criteriaQuery.from(Order.class);
        criteriaQuery.select(order);
        List<Predicate> predList = new LinkedList<>();
        predList.add(criteriaBuilder.and(criteriaBuilder.lessThan(order.get(ORDER_DATE), new Date (System.currentTimeMillis() - 15 * 60 * 1000))));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));
        predList.add(criteriaBuilder.and(criteriaBuilder.equal(order.get(PAYMENT_TYPE), PaymentTypeCode.CARD.ordinal())));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        criteriaQuery.where(predArray);
        return super.find(criteriaQuery);

    }

    public List<Order> findTopUsers(int topUsersCount) {
            CriteriaBuilder cb = super.getCriteriaBuilder();
            CriteriaQuery<Order> q = cb.createQuery(Order.class);
            Root<Order> orderRoot = q.from(Order.class);
            q.multiselect(orderRoot.get(USER), cb.count(orderRoot.get(USER)));
            q.groupBy(orderRoot.get(USER));
            q.orderBy(cb.desc(cb.count(orderRoot.get(USER))));
            List<Predicate> predList = new LinkedList<>();
            predList.add(cb.and(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.EXPIRED.ordinal())));
            predList.add(cb.or(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));

            Predicate[] predArray = new Predicate[predList.size()];
            predList.toArray(predArray);
            q.where(predArray);
            return super.getEntityManager().createQuery(q).setMaxResults(topUsersCount).getResultList();
    }

    public List<Order> findMonthRevenue() {
        CriteriaBuilder cb = super.getCriteriaBuilder();
        CriteriaQuery<Order> q = cb.createQuery(Order.class);
        Root<Order> orderRoot = q.from(Order.class);
        List<Predicate> predList = new LinkedList<>();
        predList.add(cb.and(cb.greaterThan(orderRoot.get(ORDER_DATE), DateUtil.removeDayAndTime(new Date (System.currentTimeMillis())))));
        predList.add(cb.and(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.EXPIRED.ordinal())));
        predList.add(cb.or(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));

        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        q.where(predArray);
        return super.find(q);
    }

    public List<Order> findWeekRevenue() {
        CriteriaBuilder cb = super.getCriteriaBuilder();
        CriteriaQuery<Order> q = cb.createQuery(Order.class);
        Root<Order> orderRoot = q.from(Order.class);
        List<Predicate> predList = new LinkedList<>();
        predList.add(cb.and(cb.greaterThan(orderRoot.get(ORDER_DATE), DateUtil.currentWeek(new Date (System.currentTimeMillis())))));
        predList.add(cb.and(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.EXPIRED.ordinal())));
        predList.add(cb.or(cb.notEqual(orderRoot.get(ORDER_STATUS), OrderStatusCode.AWAIT_PAYMENT.ordinal())));

        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        q.where(predArray);
        return super.find(q);
    }

}