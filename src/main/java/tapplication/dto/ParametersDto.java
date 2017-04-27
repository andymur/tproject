package tapplication.dto;

import tapplication.model.Parameters;

/**
 * Created by alexpench on 10.04.17.
 */
public class ParametersDto {
    private Long id;
    private Long productId;
    private String size ;
    private Long weight;
    private Long quantity;

    public ParametersDto() {
    }

    public ParametersDto(Parameters parameters) {
        this.id = parameters.getId();
        this.productId = parameters.getProduct();
        this.size = parameters.getSize();
        this.weight = parameters.getWeight();
        this.quantity = parameters.getQuantity();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ParametersDto{" +
                "productId=" + productId +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
