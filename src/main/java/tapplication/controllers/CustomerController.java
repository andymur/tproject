package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Customer;
import tapplication.service.LoginServiceImpl;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class CustomerController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(path = "register", method = RequestMethod.POST)
    public Object register(@RequestBody Customer customer,
                           Model model) throws AlreadyExistException {

        Customer newCustomer = loginService.create(customer);
        model.addAttribute("Customer", newCustomer);
        return "home";
    }
}
