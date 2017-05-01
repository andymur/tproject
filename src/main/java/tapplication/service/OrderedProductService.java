package tapplication.service;

import tapplication.dto.ProductDto;

import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
public interface OrderedProductService {
    List<ProductDto> getTopProducts(int count);
}
