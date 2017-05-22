package tapplication.dto;

import tapplication.model.ProductImage;

/**
 * Created by alexpench on 22.04.17.
 */
public class ProductImageDto {
    private Long id;
    private String name;
    private String url;
    private Long productId;

    public ProductImageDto() {
    }

    public ProductImageDto(ProductImage image) {
        this.id = image.getId();
        this.name = image.getName();
        this.url = image.getImage();
        this.productId = image.getProduct().getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductImageDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", productId=" + productId +
                '}';
    }
}
