package tapplication.service;

import tapplication.dto.ProductDto;
import tapplication.dto.UserDto;

import java.util.List;

/**
 * Created by alexpench on 28.04.17.
 */
public interface StatisticService {
    List<ProductDto> getTopOrderedProducts();
    List<UserDto> getTopUsers();
    Long getMonthRevenue();
    Long getWeekRevenue();
}
