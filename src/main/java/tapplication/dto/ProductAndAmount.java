package tapplication.dto;

import tapplication.model.OrderedProduct;

/**
 * Created by alexpench on 11.04.17.
 */
public class ProductAndAmount {
    private Long productId;
    private Long count;
    private String size;

    public ProductAndAmount() {
    }

    public ProductAndAmount(OrderedProduct orderedProduct) {
        this.productId = orderedProduct.getProduct().getId();
        this.count = orderedProduct.getQuantity();
        this.size = orderedProduct.getSize();
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
