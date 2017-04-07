package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "basket_product")
public class BasketProduct {
    public static final String ID = "id";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String PRODUCT_ID = "product_id";
    public static final String QUANTITY = "quantity";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @ManyToOne
    @JoinColumn(name = CUSTOMER_ID, referencedColumnName = "id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = PRODUCT_ID)
    private Product product;

    @Column(name = QUANTITY)
    private Long quantity;

    public BasketProduct(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


}
