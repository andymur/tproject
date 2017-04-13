package tapplication.dto;

import tapplication.model.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 10.04.17.
 */
public class ParametersDto {
    private Long productId;
    private List<String> sizes = new ArrayList<>();
    private List<Long> weights = new ArrayList<>();

    public ParametersDto() {
    }

    public ParametersDto(Parameters parameters) {
        this.productId = parameters.getProduct();
        this.sizes.add(parameters.getSize());
        this.weights.add(parameters.getWeight());
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<Long> getWeights() {
        return weights;
    }

    public void setWeights(List<Long> weights) {
        this.weights = weights;
    }

    @Override
    public String toString() {
        return "ParametersDto{" +
                "productId=" + productId +
                ", sizes=" + sizes +
                ", weights=" + weights +
                '}';
    }
}
