package tapplication.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.BasketDto;
import tapplication.dto.OrderDto;
import tapplication.dto.ProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by alexpench on 07.04.17.
 */
@Controller
public class OrderController extends CoreController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private ProductService productService;

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping(value = "order/create", method = RequestMethod.POST)
    public Object create(@RequestBody OrderDto orderDto, Model model){
        model.addAttribute("order", orderService.create(orderDto));
        return "payment";
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public Object getOrderPage(@RequestBody BasketDto basketDto, Model model, HttpServletResponse resp) throws IOException {
        model.addAttribute("deliveryTypes", DeliveryTypeCode.values());
        model.addAttribute("paymentTypes", PaymentTypeCode.values());
        model.addAttribute("userAddresses", userService.findBySSO(getPrincipal()).getAddresses());
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("products", productService.getProductsForBasket(basketDto));
        return "order";
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public Object getUserOrders(Model model) {
        String ssoId = getPrincipal();
        model.addAttribute("orders", orderService.getUserOrders(ssoId));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("loggedinuser", getPrincipal());
        return "orders";
    }

    @RequestMapping(value = "admin_orders", method = RequestMethod.GET)
    public Object getAllOrders(Model model) {
        logger.info("Getting all orders.start : {}", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        model.addAttribute("orders", orderService.getAllOrders());
        logger.info("Getting all orders.stop : {}", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        return "orders";
    }

    @RequestMapping(value = "orderdetails", method = RequestMethod.GET)
    public Object getOrderDetails(@RequestParam(value = "orderId") Long orderId,
                                  Model model) throws NotFoundException {
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("order", orderService.getOne(orderId));
        model.addAttribute("orderStatuses", OrderStatusCode.values());
        return "orderdetails";
    }

    @RequestMapping(value = "order", method = RequestMethod.PUT)
    public void updateStatus(@RequestBody OrderDto order, HttpServletResponse resp){
        orderService.update(order);
        resp.setStatus(200);
    }

    @RequestMapping(value = "order/repeat", method = RequestMethod.POST)
    public Object repeatOrder(@RequestBody OrderDto order, Model model){
        List<ProductDto> products =   productService.getProductsForBasket(orderService.repeatOrder(order));
        model.addAttribute("deliveryTypes", DeliveryTypeCode.values());
        model.addAttribute("paymentTypes", PaymentTypeCode.values());
        model.addAttribute("userAddresses", userService.findBySSO(getPrincipal()).getAddresses());
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("products", products);
        model.addAttribute("orderId", order.getOrderId());
        return "orderRepeat";
    }

    @ExceptionHandler(PlaceToOrderException.class)
    @ResponseBody()
    public String handleCommunicationException(PlaceToOrderException ex, HttpServletResponse response) throws IOException{
        response.setStatus(ex.getStatus().value());
        return ex.getMessage();
    }
}
