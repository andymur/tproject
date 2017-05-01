package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.ProductDto;
import tapplication.dto.UserDto;

import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
@Service("statisticService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StatisticServiceImpl implements StatisticService {
    public static final int TOP_PRODUCTS_COUNT = 10;
    public static final int TOP_USERS_COUNT = 10;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private OrderService orderService;

    @Override
    public List<ProductDto> getTopOrderedProducts() {
        return orderedProductService.getTopProducts(TOP_PRODUCTS_COUNT);
    }

    @Override
    public List<UserDto> getTopUsers() {
        return orderService.getTopUsers(TOP_USERS_COUNT);
    }

    @Override
    public Long getMonthRevenue() {
        return orderService.getMonthRevenue();
    }

    @Override
    public Long getWeekRevenue() {
        return orderService.getWeekRevenue();
    }
}
