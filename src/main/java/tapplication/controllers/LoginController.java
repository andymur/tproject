package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tapplication.model.Customer;
import tapplication.model.Role;
import tapplication.exceptions.AlreadyExistException;
import tapplication.service.LoginServiceImpl;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public Object redirect() {
//        return "login";
//    }

    @RequestMapping(path = "register", method = RequestMethod.GET)
    public Object register(@RequestParam(value = "email", required = true) String email,
                           @RequestParam(value = "password", required = true) String password,
                           @RequestParam(value = "name", required = true) String name,
                            Model model) throws AlreadyExistException {

//
//        if (loginService.isAlreadyExist(customer)) {
//            throw new AlreadyExistException();
//        }

        Customer customer = loginService.create(name, email, password, new Role(1L));
        model.addAttribute("Customer", customer);
        return "home";
    }

//    @RequestMapping(path = "login", method = RequestMethod.GET)
//    public Object login(@RequestParam(value = "email", required = true) String email,
//                        @RequestParam(value = "password", required = true) String password,
//                        Model model) {
//        String targetModel = "";
//        //validate email and password
//        if (!loginService.validateEmail(email)) {
//            throw new NotFoundException();
//        }
//        if (!loginService.validatePassword(email, password)) {
//            throw new InvalidPasswordException();
//        }
//
//        //if validation is passed, then return view related to user role
//        Customer loggedCustomer = loginService.getCustomerByEmail(email);
//        String customerRole = loggedCustomer.getRole().getName().toString();
//        if (customerRole.equals("user")) {
//            model.addAttribute("Customer", loggedCustomer);
//            targetModel = "home";
//        } else if (customerRole.equals("admin")) {
//            model.addAttribute("Admin", loggedCustomer);
//            targetModel = "admin";
//        }
//        return targetModel;
//    }
}
