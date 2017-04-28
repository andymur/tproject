package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "ordered_product")
public class OrderedProduct {
    public static final String ID = "id";
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT = "product";
    public static final String QUANTITY = "quantity";
    public static final String ORDER_ID = "order_id";
    public static final String PRICE = "price";
    public static final String SIZE = "size";
    public static final String ID1 = "id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @OneToOne
    @JoinColumn(name = PRODUCT_ID)
    private Product product;

    @Column(name = QUANTITY)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = ORDER_ID, referencedColumnName = ID1)
    private Order order;

    @Column(name = PRICE)
    private Long price;

    @Column(name = SIZE)
    private String size;

    public OrderedProduct(){}
    public OrderedProduct(Product product, Long count){
        this.product = product;
        this.quantity = count;
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
