package tapplication.controllers.dto;

/**
 * Created by alexpench on 07.04.17.
 */
public class BasketProductDto {

    private Long productId;
    private Long quantity;
    private Long customerId;

    public BasketProductDto(){}

    public BasketProductDto(Long productId, Long quantity, Long customerId) {
        this.productId = productId;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
