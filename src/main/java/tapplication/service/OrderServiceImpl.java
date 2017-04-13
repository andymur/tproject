package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.OrderDto;
import tapplication.dto.ProductAndAmount;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.model.Product;
import tapplication.model.User;
import tapplication.repositories.OrderDao;

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
public class OrderServiceImpl {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ProductService productService;


    public Object create(OrderDto orderDto) throws NotFoundException, PlaceToOrderException {
        Order newOrder = new Order();
        putProductsToNewOrder(orderDto, newOrder);

        newOrder.setUser(userService.findById(orderDto.getUserId()));
        newOrder.setAddress(addressService.save(orderDto));
        newOrder.setDeliveryType(orderDto.getDeliveryType());
        newOrder.setPaymentType(orderDto.getPaymentType());
        newOrder.setPaymentStatus(AWAIT_PAYMENT);
        newOrder.setOrderStatus(OrderStatusCode.AWAIT_PAYMENT);
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        orderDao.persist(newOrder);
        newOrder.getOrderedProducts().forEach(orderedProduct -> orderedProduct.setOrder(newOrder));
//        basketService.cleanBasket(orderDto);
        return orderDto.setNewOrderDetails(newOrder);
    }

    public List<OrderDto> getUserOrders(String ssoId) {
        User user = userService.findBySSO(ssoId);
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
        if (order == null){
            throw new NotFoundException();
        }
        order.setOrderStatus(orderToUpdate.getOrderStatusCode());
        orderDao.merge(order);
    }

    private void putProductsToNewOrder(OrderDto orderDto, Order newOrder) throws NotFoundException, PlaceToOrderException {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        OrderedProduct orderedProduct = new OrderedProduct();
        for (ProductAndAmount productAndAmount : orderDto.getBasketDto().getRows()) {
            Long quantity = productAndAmount.getCount();
            Product product = productService.moveToOrder(productAndAmount.getProductId(), quantity);
            orderedProduct.setProduct(product);
            orderedProduct.setQuantity(quantity);
            orderedProductList.add(orderedProduct);
        }
        newOrder.setOrderedProducts(orderedProductList);
    }
}
