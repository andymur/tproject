package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "payment_status")
public class PaymentStatus {
    enum PaymentStatusCode {AWAIT_PAYMENT, PAID}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status_code")
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatusCode statusCode;

    @Column(name = "description")
    private String description;

    public PaymentStatus(){}

    public PaymentStatus(PaymentStatusCode statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentStatus{" +
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

    public PaymentStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(PaymentStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
