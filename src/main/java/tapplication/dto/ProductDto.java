package tapplication.dto;

import tapplication.model.OrderedProduct;
import tapplication.model.Parameters;
import tapplication.model.Product;
import tapplication.model.ProductImage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 10.04.17.
 */
public class ProductDto {
    private Long id;
    private String brand;
    private String name;
    private String model;
    private String color;
    private String description;
    private Long price;
    private String category;
    private String mainImage;
    private String longpic;
    private List<ProductImageDto> images;
    private List<ParametersDto> parameters;
    private Long count;
    private Long quantity;
    private List<String> sizes;
    private String size;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.brand = product.getBrand().getName();
        this.name = product.getName();
        this.model = product.getModel();
        this.color = product.getColor();
        this.description = product.getDescription();
        this.category = product.getCategory().getName();
        this.price = product.getPrice();
        this.parameters = product.getParameters().stream()
                .map(ParametersDto::new)
                .collect(Collectors.toList());
        this.sizes = product.getParameters().stream()
                .map(Parameters::getSize).collect(Collectors.toList());
        this.images = product.getImages().stream()
                .map(ProductImageDto::new)
                .collect(Collectors.toList());
        this.mainImage = product.getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("new.png");
        this.longpic = product.getImages().stream()
                .filter(im -> im.getName().equals("longpic"))
                .map(ProductImage::getImage)
                .findFirst().orElse("http://res.cloudinary.com/alexpench/image/upload/v1494595933/linus-bike-gaston-3-lifestyle2-2000x931_m8q2kl.jpg");
    }

    public ProductDto(Product product, Long count, String size) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.count = count;
        this.name = product.getName();
        this.model = product.getModel();
        this.size = size;
        this.mainImage = product.getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("new.png");

    }

    public ProductDto(OrderedProduct orderedProduct) {
        this.id = orderedProduct.getProduct().getId();
        this.price = orderedProduct.getPrice();
        this.count = orderedProduct.getQuantity();
        this.name = orderedProduct.getProduct().getName();
        this.model = orderedProduct.getProduct().getModel();
        this.size = orderedProduct.getSize();
        this.mainImage = orderedProduct.getProduct().getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("new.png");

    }

    public ProductDto(Product product, Long count) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.count = count;
        this.name = product.getName();
        this.model = product.getModel();
        this.sizes = product.getParameters().stream()
                .map(Parameters::getSize).collect(Collectors.toList());
        this.mainImage = product.getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("new.png");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ProductImageDto> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDto> images) {
        this.images = images;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public String getLongpic() {
        return longpic;
    }

    public void setLongpic(String longpic) {
        this.longpic = longpic;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
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
