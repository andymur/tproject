package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.OrderDto;
import tapplication.dto.ProductAndAmount;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.model.Product;
import tapplication.model.User;
import tapplication.repositories.OrderDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static tapplication.service.PaymentStatusCode.AWAIT_PAYMENT;

/**
 * Created by alexpench on 07.04.17.
 */
@Service("orderService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DataHelperService dataHelperService;

    Logger logger = LoggerFactory.getLogger(getClass());


    public OrderDto create(OrderDto orderDto) {
        Order newOrder = new Order();
        putProductsToNewOrder(orderDto, newOrder);
        newOrder.setUser(userService.findBySSO(dataHelperService.getPrincipal()));
        orderDto.setUserId(newOrder.getUser().getId());
        if (orderDto.getDeliveryAddressDto() != null) {
            newOrder.setAddress(addressService.save(orderDto.getDeliveryAddressDto()));
        } else {
            newOrder.setAddress(addressService.findOne(1L));
        } //in case of self we setup shop address which is created at the init.
        newOrder.setDeliveryType(orderDto.getDeliveryType());
        newOrder.setPaymentType(orderDto.getPaymentType());
        newOrder.setPaymentStatus(AWAIT_PAYMENT);
        newOrder.setOrderStatus(OrderStatusCode.AWAIT_PAYMENT);
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        orderDao.persist(newOrder);
        newOrder.getOrderedProducts().forEach(orderedProduct -> orderedProduct.setOrder(newOrder));
        logger.info("New order: {} has been created", newOrder.getId());
        orderDto.setOrderId(newOrder.getId());
        return orderDto;
    }

    public List<OrderDto> getUserOrders() {
        User user = userService.findBySSO(dataHelperService.getPrincipal());
        List<Order> orders = orderDao.find(Order.USER_ENTITY, user);
        return orders.stream().map(order -> new OrderDto().prepareForUser(order)).collect(Collectors.toList());
    }

    public List<OrderDto> getAllOrders() {
        return orderDao.selectAll().stream().map(order -> new OrderDto().prepareForUser(order)).collect(Collectors.toList());
    }

    public OrderDto getOne(Long orderId) {
        return new OrderDto().prepareForAdmin(orderDao.findOne(orderId));
    }

    public void update(OrderDto orderToUpdate) {
        Order order = orderDao.findOne(orderToUpdate.getOrderId());
        if (order == null) {
            logger.info("Order: {} not found", orderToUpdate.getOrderId());
            throw new NotFoundException();
        }
        if (orderToUpdate.getPaymentStatusCode() != null) {
            order.setPaymentStatus(orderToUpdate.getPaymentStatusCode());
            logger.info("Order:{} payment status has been changed to {}", orderToUpdate.getOrderId(), orderToUpdate.getPaymentStatusCode());
        }
        order.setOrderStatus(orderToUpdate.getOrderStatusCode());
        orderDao.merge(order);
        logger.info("Order: {} status has changed to {}", orderToUpdate.getOrderId(), orderToUpdate.getOrderStatusCode());
    }

    public void updateExpiredOrders() {
        List<Order> orders = orderDao.findAllExpired();
        orders.forEach(order -> {
                    order.setOrderStatus(OrderStatusCode.EXPIRED);
                    logger.info("{} Order {} set to EXPIRED", LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), order.getId());
                }
        );
        orders.forEach(order -> order.getOrderedProducts().forEach(orderedProduct -> productService.moveFromExpiredOrder(orderedProduct.getProduct(), orderedProduct.getQuantity())));
    }

    private void putProductsToNewOrder(OrderDto orderDto, Order newOrder) {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        OrderedProduct orderedProduct = new OrderedProduct();
        for (ProductAndAmount productAndAmount : orderDto.getProductAndAmounts()) {
            Long quantity = productAndAmount.getCount();
            String size = productAndAmount.getSize();
            Product product = productService.moveToOrder(productAndAmount.getProductId(), quantity, size);
            orderedProduct.setProduct(product);
            orderedProduct.setQuantity(quantity);
            orderedProduct.setPrice(product.getPrice());
            orderedProduct.setSize(size);
            orderedProductList.add(orderedProduct);
        }
        newOrder.setOrderedProducts(orderedProductList);
    }

    public List<ProductAndAmount> repeatOrder(OrderDto orderDto) {
        return orderDao.findOne(orderDto.getOrderId()).getOrderedProducts()
                .stream()
                .map(ProductAndAmount::new)
                .collect(Collectors.toList());
    }
}
