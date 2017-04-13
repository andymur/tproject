package tapplication.model;

import tapplication.service.DeliveryTypeCode;
import tapplication.service.OrderStatusCode;
import tapplication.service.PaymentStatusCode;
import tapplication.service.PaymentTypeCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexpench on 22.03.17.
 */
@Entity
@Table(name = "user_order")
public class Order {

    public static final String DELIVERY_ADDRESS_ID = "delivery_address_id";
    public static final String USER_ID = "user_id";
    public static final String ORDER_DATE = "order_date";
    public static final String ORDER = "order";
    public static final String ORDER_STATUS_ID = "order_status_id";
    public static final String PAYMENT_STATUS_ID = "payment_status_id";
    public static final String PAYMENT_TYPE_ID = "payment_type_id";
    public static final String DELIVERY_TYPE_ID = "delivery_type_id";
    public static final String USER_ENTITY = "user";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = DELIVERY_ADDRESS_ID)
    private Address address;

    @OneToOne
    @JoinColumn(name = USER_ID)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = ORDER_DATE)
    private Date orderDate;

    @OneToMany(mappedBy = ORDER, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = ORDER_STATUS_ID)
    private OrderStatusCode orderStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = PAYMENT_STATUS_ID)
    private PaymentStatusCode paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = PAYMENT_TYPE_ID)
    private PaymentTypeCode paymentType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = DELIVERY_TYPE_ID)
    private DeliveryTypeCode deliveryType;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public OrderStatusCode getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusCode orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatusCode getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusCode paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentTypeCode getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeCode paymentType) {
        this.paymentType = paymentType;
    }

    public DeliveryTypeCode getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryTypeCode deliveryType) {
        this.deliveryType = deliveryType;
    }
}
