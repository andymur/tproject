package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.ProductDto;
import tapplication.model.OrderedProduct;
import tapplication.repositories.OrderedProductDao;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 28.04.17.
 */
@Service("orderedProductService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrderedProductServiceImpl implements OrderedProductService {
    @Autowired
    private OrderedProductDao orderedProductDao;

    @Override
    public List<ProductDto> getTopProducts(int count) {
        List<OrderedProduct> orderedProducts = orderedProductDao.findTopProducts(count);
        return (orderedProducts.size() == 0) ? Collections.emptyList() : orderedProducts.stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
