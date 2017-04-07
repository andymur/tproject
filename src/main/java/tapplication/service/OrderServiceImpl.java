package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.controllers.dto.OrderDto;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.repositories.OrderDao;

import java.util.Date;

/**
 * Created by alexpench on 07.04.17.
 */
@Service("orderService")
public class OrderServiceImpl {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ProductService productService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object create(OrderDto orderDto) throws NotFoundException {
        Order newOrder = new Order();
        newOrder.setCustomer(customerService.findOne(orderDto.getCustomerId()));
        newOrder.setAddress(addressService.findOne(orderDto.getDeliveryAddressId()));
        newOrder.setDeliveryType(orderDto.getDeliveryType());
        newOrder.setPaymentType(orderDto.getPaymentType());
        newOrder.setPaymentStatus(Order.PaymentStatusCode.AWAIT_PAYMENT);
        newOrder.setOrderStatus(Order.OrderStatusCode.AWAIT_PAYMENT);
        orderDto.getBasketProductsDtoList()
                .forEach(p -> {
                    try {
                        newOrder.getOrderedProducts()
                                .add(new OrderedProduct(productService.findOne(p.getProductId()), p.getQuantity()));
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        orderDao.persist(newOrder);

        return orderDto.copyDetails(newOrder);
    }
}
