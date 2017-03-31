package tapplication.model;

import javax.persistence.*;
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
    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = CATEGORY_IMAGE)
    private String categoryImage;

    @ManyToMany
    @JoinTable(name = PRODUCT_CATEGORY, joinColumns = {@JoinColumn(name = CATEGORY_ID)},
            inverseJoinColumns = {@JoinColumn(name = PRODUCT_ID)})
    private List<Product> products;

    public Category(String name, String categoryImage) {
        this.name = name;
        this.categoryImage = categoryImage;
    }

    public Category() {}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
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

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
