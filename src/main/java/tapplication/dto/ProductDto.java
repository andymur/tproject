package tapplication.dto;

import tapplication.model.Product;
import tapplication.model.ProductImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 10.04.17.
 */
public class ProductDto {
    private Long productId;
    private String brand;
    private String name;
    private String model;
    private String color;
    private String description;
    private Long price;
    private String category;
    private String mainImage;
    private String icon;
    private List<String> images = new ArrayList<>();
    private List<ParametersDto> parameters = new ArrayList<>();
    private Long count;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.productId = product.getId();
        this.brand = product.getBrand().getName();
        this.name = product.getName();
        this.model = product.getModel();
        this.color = product.getColor();
        this.description = product.getDescription();
        this.category = product.getCategory().getName();
        this.price = product.getPrice();
        product.getImages().forEach(productImage -> this.images.add(productImage.getImage()));
        product.getParameters().forEach(parameter -> this.parameters.add(new ParametersDto(parameter)));
        this.mainImage = product.getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("/new.png");
    }

    public ProductDto(Product product, Long count) {
        this.productId = product.getId();
        this.price = product.getPrice();
        this.count = count;
        this.name = product.getName();
        this.model = product.getModel();
        this.icon = product.getImages().stream()
                .filter(im -> im.getName().equals("icon"))
                .map(ProductImage::getImage)
                .findFirst().orElse("/dummy_icon.png");
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<ParametersDto> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParametersDto> parameters) {
        this.parameters = parameters;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
