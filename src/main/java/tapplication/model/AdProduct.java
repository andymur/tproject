package tapplication.model;

import javax.persistence.*;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Entity
@Table(name = AdProduct.TABLE_AD_PRODUCTS)
public class AdProduct {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String TABLE_AD_PRODUCTS = "ad_products";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long id;

    @OneToOne
    @JoinColumn(name = COLUMN_PRODUCT_ID)
    private Product product;

    public AdProduct() {
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
}


