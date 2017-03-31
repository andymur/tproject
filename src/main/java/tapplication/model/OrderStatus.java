package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "order_status")
public class OrderStatus {
    enum OrderStatusCode {AWAIT_PAYMENT, AWAIT_SHIPMENT, SHIPPED, DELIVERED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status_code")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatusCode statusCode;

    @Column(name = "description")
    private String description;

    public OrderStatus(){}

    public OrderStatus(OrderStatusCode statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", statusCode=" + statusCode +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(OrderStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
