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
import tapplication.repositories.OrderDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static tapplication.service.OrderStatusCode.ORDER_AWAIT_PAYMENT;
import static tapplication.service.PaymentStatusCode.PAYMENT_AWAIT_PAYMENT;

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
        newOrder.setAddress(addressService.save(orderDto));
        newOrder.setDeliveryType(orderDto.getDeliveryType());
        newOrder.setPaymentType(orderDto.getPaymentType());
        newOrder.setPaymentStatus(PAYMENT_AWAIT_PAYMENT);
        newOrder.setOrderStatus(ORDER_AWAIT_PAYMENT);
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        orderDao.persist(newOrder);
        newOrder.getOrderedProducts().forEach(orderedProduct -> orderedProduct.setOrder(newOrder));
//        basketService.cleanBasket(orderDto);
        orderDto.setNewOrderDetails(newOrder);
        return orderDto;
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
