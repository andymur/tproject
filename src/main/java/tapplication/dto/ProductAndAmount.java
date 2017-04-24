package tapplication.dto;

/**
 * Created by alexpench on 11.04.17.
 */
public class ProductAndAmount {
    private Long productId;
    private Long count;
    private String size;

    public ProductAndAmount() {
    }

    public ProductAndAmount(Long productId, Long count, String size) {
        this.productId = productId;
        this.count = count;
        this.size = size;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
