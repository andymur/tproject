package tapplication.service;

import tapplication.dto.OrderDto;
import tapplication.dto.ProductAndAmount;
import tapplication.dto.UserDto;

import java.util.List;

/**
 * Created by apenchukov on 4/28/2017.
 */
public interface OrderService {
    OrderDto create(OrderDto orderDto);

    List<OrderDto> getUserOrders();

    List<OrderDto> getAllOrders();

    OrderDto getOne(Long orderId);

    void update(OrderDto orderToUpdate);

    void updateExpiredOrders();

    List<ProductAndAmount> getHistoricalData(OrderDto orderDto);

    List<UserDto> getTopUsers(int topUsersCount);

    Long getMonthRevenue();

    Long getWeekRevenue();
}