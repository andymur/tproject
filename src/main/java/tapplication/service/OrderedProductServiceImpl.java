package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.dto.OrderedProductDto;
import tapplication.repositories.OrderedProductDao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 28.04.17.
 */
@Service("orderedProductService")
public class OrderedProductServiceImpl implements OrderedProductService{
    @Autowired
    private OrderedProductDao orderedProductDao;
    @Override
    public List<OrderedProductDto> getTopOrderedProducts(int count) {
        return orderedProductDao.findTopProducts(count).stream().map(OrderedProductDto::new).collect(Collectors.toList());
    }
}
