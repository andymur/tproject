package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = ProductImage.TABLE_PRODUCT_IMAGE)
public class ProductImage {
    public static final String NAME = "name";
    public static final String IMAGE = "image";
    public static final String PRODUCT_ID = "product_id";
    public static final String ID = "id";
    public static final String TABLE_PRODUCT_IMAGE = "product_image";
    public static final String REFERENCED_ID = "id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = IMAGE)
    private String image;

    @ManyToOne
    @JoinColumn(name = PRODUCT_ID, referencedColumnName = REFERENCED_ID)
    private Product product;

    public ProductImage() {}

    public ProductImage(String name, String image, Product product) {
        this.name = name;
        this.image = image;
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", product=" + product +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getProduct() {
        return product.getId();
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

