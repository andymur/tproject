package tapplication.order.deliveryType;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "delivery_type")
public class DeliveryType {
    enum DeliveryTypeCode {SELF, DELIVER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_code")
    @Enumerated(EnumType.ORDINAL)
    private DeliveryTypeCode typeCode;

    @Column(name = "description")
    private String description;

    public DeliveryType(){}

    public DeliveryType(DeliveryTypeCode typeCode, String description) {
        this.typeCode = typeCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", typeCode=" + typeCode +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryTypeCode getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(DeliveryTypeCode typeCode) {
        this.typeCode = typeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
