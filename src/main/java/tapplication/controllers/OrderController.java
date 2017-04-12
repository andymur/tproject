package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.dto.OrderDto;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.model.User;
import tapplication.service.DeliveryTypeCode;
import tapplication.service.OrderServiceImpl;
import tapplication.service.PaymentTypeCode;
import tapplication.service.UserServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexpench on 07.04.17.
 */
@Controller
@RequestMapping(value = "order")
public class OrderController extends CoreController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(@RequestBody OrderDto orderDto, Model model) throws NotFoundException, PlaceToOrderException {
        User user = userService.findBySSO(getPrincipal());
        orderDto.setUserId(user.getId());
        model.addAttribute("order", orderService.create(orderDto));
        return "payment";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object getOrderPage(Model model, HttpServletResponse resp) throws IOException {
        model.addAttribute("deliveryTypes", DeliveryTypeCode.values());
        model.addAttribute("paymentTypes", PaymentTypeCode.values());
        model.addAttribute("userAddresses", userService.findBySSO(getPrincipal()).getAddresses());
        model.addAttribute("loggedinuser", getPrincipal());
        return "order";
    }

}
