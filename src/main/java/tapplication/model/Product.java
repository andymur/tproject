package tapplication.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by alexpench on 22.03.17.
 */
@Entity
@Table(name = Product.TABLE_PRODUCT)
public class Product {


    public static final String TABLE_PRODUCT = "product";
    public static final String CHANGE_DATE = "change_date";
    public static final String ID = "id";
    public static final String BRAND_ID = "brand_id";
    public static final String NAME = "name";
    public static final String MODEL = "model";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";
    public static final String PRODUCTS = "products";
    public static final String COLOR = "color";
    public static final String CATEGORY_ID = "category_id";
    public static final String ID1 = "id";
    public static final String PRODUCT_CATEGORY = "category";
    public static final String PARAMETERS = "parameters";
    public static final String BRAND = "brand";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @OneToOne
    @JoinColumn(name = BRAND_ID)
    private Brand brand;

    @Column(name = NAME)
    private String name;

    @Column(name = MODEL)
    private String model;

    @Column(name = COLOR)
    private String color;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = PRICE)
    private Long price;

    @Column(name = QUANTITY)
    private Long quantity;

    @Temporal(TemporalType.DATE)
    @Column(name = CHANGE_DATE)
    private Date changeDate;

    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, referencedColumnName = ID1)
    private Category category;

    @OneToMany(mappedBy = TABLE_PRODUCT, cascade = CascadeType.PERSIST)
    private List<ProductImage> images;

    @OneToMany(mappedBy = TABLE_PRODUCT, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Parameters> parameters;

    public Product(Brand brand, String name, String model, String color, String description, Long price, Long quantity, Date changeDate, Category category, List<ProductImage> images, List<Parameters> parameters) {
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.changeDate = changeDate;
        this.category = category;
        this.images = images;
        this.parameters = parameters;
    }

    public Product() {
    }

    public Product(Long productId) {
        this.id = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }

    public void increaseQuantity(Long quantity) {
        this.quantity = this.quantity + quantity;
    }
}
