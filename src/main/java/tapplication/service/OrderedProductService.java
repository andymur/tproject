package tapplication.service;

import tapplication.dto.OrderedProductDto;

import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
public interface OrderedProductService {
    List<OrderedProductDto> getTopOrderedProducts(int count);
}
