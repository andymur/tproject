package tapplication.controllers.dto;

/**
 * Created by alexpench on 11.04.17.
 */
public class ProductAndAmount {
    private Long productId;
    private Long count;

    public ProductAndAmount() {
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
}
