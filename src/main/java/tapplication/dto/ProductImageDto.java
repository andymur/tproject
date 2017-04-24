package tapplication.dto;

/**
 * Created by alexpench on 22.04.17.
 */
public class ProductImageDto {
    private String name;
    private String url;
    private Long productId;

    public ProductImageDto() {
    }

    public ProductImageDto(String name, String url, Long productId) {
        this.name = name;
        this.url = url;
        this.productId = productId;
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

    @Override
    public String toString() {
        return "ProductImageDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", productId=" + productId +
                '}';
    }
}
