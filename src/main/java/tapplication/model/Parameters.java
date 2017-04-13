package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = Parameters.TABLE_PARAMETERS)
public class Parameters {
    public static final String TABLE_PARAMETERS = "parameters";
    public static final String ID = "id";
    public static final String SIZE = "size";
    public static final String WEIGHT = "weight";
    public static final String PRODUCT_ID = "product_id";
    public static final String REFERENCED_ID = "id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = SIZE)
    private String size;

    @Column(name = WEIGHT)
    private Long weight;

    @ManyToOne
    @JoinColumn(name = PRODUCT_ID, referencedColumnName = REFERENCED_ID)
    private Product product;

    public Parameters(){}

    public Parameters(String size, Long weight, Long productId) {
        this.size = size;
        this.weight = weight;
        this.product = new Product(productId);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", weight=" + weight +'}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

//    @JsonIgnore
    public Long getProduct() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
