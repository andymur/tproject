package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "ordered_product")
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "price")
    private Long price;

    public OrderedProduct(){}

    public OrderedProduct(Product product, Long quantity, Long price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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
}
