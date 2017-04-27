package tapplication.dto;

/**
 * Created by alexpench on 07.04.17.
 */
public class BasketProductDto {

    private Long recordId;
    private Long productId;
    private Long quantity;
    private Long userId;
    private String productName;
    public BasketProductDto(){}

    public BasketProductDto(Long recordId, String productName, Long quantity, Long userId, Long productId) {
        this.recordId = recordId;
        this.productName = productName;
        this.quantity = quantity;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
