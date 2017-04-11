package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.controllers.dto.OrderDto;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.Order;
import tapplication.model.OrderedProduct;
import tapplication.model.Product;
import tapplication.repositories.OrderDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static tapplication.model.Order.OrderStatusCode.ORDER_AWAIT_PAYMENT;
import static tapplication.model.Order.PaymentStatusCode.PAYMENT_AWAIT_PAYMENT;

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
    @Autowired
    private BasketServiceImpl basketService;


    public Object create(OrderDto orderDto) throws NotFoundException, PlaceToOrderException {
        Order newOrder = new Order();
        putProductsToNewOrder(orderDto, newOrder);
        newOrder.setUser(userService.findById(orderDto.getUserId()));
        newOrder.setAddress(addressService.findOne(orderDto.getDeliveryAddressId()));
        newOrder.setDeliveryType(orderDto.getDeliveryType());
        newOrder.setPaymentType(orderDto.getPaymentType());
        newOrder.setPaymentStatus(PAYMENT_AWAIT_PAYMENT);
        newOrder.setOrderStatus(ORDER_AWAIT_PAYMENT);
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        orderDao.persist(newOrder);
        newOrder.getOrderedProducts().forEach(orderedProduct -> orderedProduct.setOrder(newOrder));
        basketService.cleanBasket(orderDto);
        orderDto.setNewOrderDetails(newOrder);
        return orderDto;
    }

    private void putProductsToNewOrder(OrderDto orderDto, Order newOrder) throws NotFoundException, PlaceToOrderException {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        OrderedProduct orderedProduct = new OrderedProduct();
        for (BasketProductDto basketProduct : orderDto.getBasketProductsDtoList()) {
            Long quantity = basketProduct.getQuantity();
            Product product = productService.moveToOrder(basketProduct.getProductId(), quantity);
            orderedProduct.setProduct(product);
            orderedProduct.setQuantity(quantity);
            orderedProductList.add(orderedProduct);
        }
        newOrder.setOrderedProducts(orderedProductList);
    }
}
