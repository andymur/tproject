package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = Brand.TABLE_BRAND)
public class Brand {
    public static final String TABLE_BRAND = "brand";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String BRAND_IMAGE = "brand_image";
    public static final String PRODUCT_ID = "product_id";
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = BRAND_IMAGE)
    private String brandImage;

//    @OneToOne
//    @JoinColumn(name = PRODUCT_ID)
//    private Product product;
//
//    public Long getProduct() {
//        return product.getId();
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public Brand(){}

    public Brand(String name, String brandImage) {
        this.name = name;
        this.brandImage = brandImage;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandImage='" + brandImage + '\'' +
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

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }
}
