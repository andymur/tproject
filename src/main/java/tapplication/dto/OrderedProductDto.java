package tapplication.dto;

import tapplication.model.OrderedProduct;

/**
 * Created by alexpench on 28.04.17.
 */
public class OrderedProductDto {

    Long productId;
    Long quantity;
    Long price;
    String size;

    public OrderedProductDto() {
    }

    public OrderedProductDto(OrderedProduct product) {
        this.productId = product.getProduct().getId();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.size = product.getSize();
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
