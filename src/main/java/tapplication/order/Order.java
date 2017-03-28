package tapplication.order;

import tapplication.customer.address.Address;
import tapplication.customer.Customer;
import tapplication.order.deliveryType.DeliveryType;
import tapplication.order.orderStatus.OrderStatus;
import tapplication.order.orderedProduct.OrderedProduct;
import tapplication.order.paymentStatus.PaymentStatus;
import tapplication.order.paymentType.PaymentType;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * Created by alexpench on 22.03.17.
 */
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "delivery_address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private Instant orderDate;

    @PrePersist
    public void prePersist() {
        orderDate = Instant.now();
    }

    @OneToMany(mappedBy = "order")
    private List<OrderedProduct> orderedProducts;

    @OneToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

    public Order(){}

    public Order(Address address, Customer customer, List<OrderedProduct> orderedProducts, OrderStatus orderStatus, PaymentStatus paymentStatus, PaymentType paymentType, DeliveryType deliveryType) {
        this.address = address;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address=" + address +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", orderedProducts=" + orderedProducts +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", paymentType=" + paymentType +
                ", deliveryType=" + deliveryType +
                '}';
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
