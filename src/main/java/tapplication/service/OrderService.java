package tapplication.service;

import tapplication.dto.OrderDto;
import tapplication.dto.ProductAndAmount;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.model.Product;
import tapplication.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static tapplication.service.PaymentStatusCode.AWAIT_PAYMENT;

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
}