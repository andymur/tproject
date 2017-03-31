package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "payment_type")
public class PaymentType {
    enum TypeCode {CARD, CASH}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_code")
    @Enumerated(EnumType.ORDINAL)
    private TypeCode typeCode;

    @Column(name = "description")
    private String description;

    public PaymentType(){}

    public PaymentType(TypeCode typeCode, String description) {
        this.typeCode = typeCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
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

    public TypeCode getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(TypeCode typeCode) {
        this.typeCode = typeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
