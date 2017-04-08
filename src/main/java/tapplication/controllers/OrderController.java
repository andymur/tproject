package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.controllers.dto.OrderDto;
import tapplication.exceptions.NotFoundException;
import tapplication.exceptions.PlaceToOrderException;
import tapplication.service.OrderServiceImpl;

/**
 * Created by alexpench on 07.04.17.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @RequestMapping(value = "order/create", method = RequestMethod.POST)
    public Object create(@RequestBody OrderDto orderDto) throws NotFoundException, PlaceToOrderException {
        return orderService.create(orderDto);
    }

}
