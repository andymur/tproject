package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Customer;
import tapplication.service.CustomerServiceImpl;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl loginService;

    @ResponseBody
    @RequestMapping(path = "register", method = RequestMethod.POST)
    public Object register(@RequestBody Customer customer) throws AlreadyExistException {
        Customer newCustomer = loginService.create(customer);
        newCustomer.setPassword("");
        return newCustomer;
    }
}
