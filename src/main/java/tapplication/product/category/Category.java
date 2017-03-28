package tapplication.product.category;

import tapplication.product.Product;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alexpench on 27.03.17.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_image")
    private String categoryImage;

    @OneToOne
    @JoinColumn(name = "id")
    private Category parentCategory;

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;

    public Category(String name, String categoryImage, Category parentCategory) {
        this.name = name;
        this.categoryImage = categoryImage;
        this.parentCategory = parentCategory;
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
