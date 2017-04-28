package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.OrderedProductDto;
import tapplication.dto.ProductDto;

import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
@Service("statisticService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StatisticServiceImpl implements StatisticService {
    public static final int TOP_PRODUCTS_COUNT = 10;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private UserService userService;

    @Override
    public List<ProductDto> getTopOrderedProducts() {
        List<ProductDto> productDtos = orderedProductService.getTopOrderedProducts(TOP_PRODUCTS_COUNT);
        return productDtos;
    }

    @Override
    public List<String> getTopUsers() {
        return null;
    }

    @Override
    public Long getMonthRevenue() {
        return null;
    }

    @Override
    public Long getWeekRevenue() {
        return null;
    }
}
