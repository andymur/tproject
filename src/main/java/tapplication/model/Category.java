package tapplication.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = Category.TABLE_CATEGORY)
public class Category {
    public static final String TABLE_CATEGORY = "category";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CATEGORY_IMAGE = "category_image";
    public static final String PRODUCT_CATEGORY = "product_category";
    public static final String PRODUCT_ID = "product_id";
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY = "category";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = CATEGORY_IMAGE)
    private String imageUrl;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = PRODUCT_CATEGORY,
//            joinColumns = {@JoinColumn(name = CATEGORY_ID)},
//            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
//    private List<Product> products;

    @OneToMany(mappedBy = CATEGORY, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();


    public Category(String name, String categoryImage, List<Product> products) {
        this.name = name;
        this.imageUrl = categoryImage;
        this.products = products;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name +
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //    @JsonIgnore
//    public List<Long> getProducts() {
//        List<Long> productIds = new ArrayList<>();
//        products.forEach(p -> productIds.addProducts(p.getId()));
//        return productIds;
//    }
//
//    public void setProducts(Product product) {
//        this.products = new ArrayList<>();
//        this.products.addProducts(product);
//    }
//    @JsonIgnore
    public List<Long> getProducts() {
        List<Long> productIds = new ArrayList<>();
        products.forEach(p -> productIds.add(p.getId()));
        return productIds;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
