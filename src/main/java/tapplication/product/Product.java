package tapplication.product;

import tapplication.product.brand.Brand;
import tapplication.product.category.Category;
import tapplication.product.parameters.Parameters;
import tapplication.product.productImage.ProductImage;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by alexpench on 22.03.17.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Column(name = "quantity")
    private Long quantity;

    @Temporal(TemporalType.DATE)
    @Column(name = "change_date")
    private Date changeDate;

    @ManyToMany(mappedBy="products")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product")
    private List<Parameters> parameters;
}
