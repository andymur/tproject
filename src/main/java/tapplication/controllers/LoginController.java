package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tapplication.exceptions.InvalidDataException;
import tapplication.model.Customer;
import tapplication.service.CustomerServiceImpl;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class LoginController {
    @Autowired
    private CustomerServiceImpl loginService;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public Object redirect() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(path = "login", method = RequestMethod.POST)
    public Object login(@RequestBody Customer customer, Model model) throws InvalidDataException {
        customer = loginService.getCustomerByEmail(customer);
        customer.setPassword("");
        return customer;
    }
}
