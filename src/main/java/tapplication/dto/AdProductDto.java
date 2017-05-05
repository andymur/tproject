package tapplication.dto;

import tapplication.model.Product;
import tapplication.model.ProductImage;

/**
 * Created by apenchukov on 5/3/2017.
 */
public class AdProductDto {
    private Long productId;
    private String name;
    private Long price;
    private String imageUrl;


    public AdProductDto() {
    }

    public AdProductDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.imageUrl = product.getImages().stream()
                .filter(im -> im.getName().equals("main"))
                .map(ProductImage::getImage)
                .findFirst().orElse("new.png");
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
