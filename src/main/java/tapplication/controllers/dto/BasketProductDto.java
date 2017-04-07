package tapplication.controllers.dto;

/**
 * Created by alexpench on 07.04.17.
 */
public class BasketProductDto {

    private Long recordId;
    private Long productId;
    private Long quantity;
    private Long customerId;
    private String productName;
    public BasketProductDto(){}

    public BasketProductDto(Long productId, Long quantity, Long customerId) {
        this.productId = productId;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    public BasketProductDto( Long recordId, String productName, Long quantity, Long customerId, Long productId) {
        this.recordId = recordId;
        this.productName = productName;
        this.quantity = quantity;
        this.customerId = customerId;
        this.productId = productId;
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

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
