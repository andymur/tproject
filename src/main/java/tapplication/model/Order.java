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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "delivery_address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "order_status_id")
    private OrderStatusCode orderStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_status_id")
    private PaymentStatusCode paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_type_id")
    private PaymentTypeCode paymentType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "delivery_type_id")
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
