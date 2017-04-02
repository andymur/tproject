package tapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alexpench on 02.04.17.
 */
@Controller
public class MainPageController {
    @RequestMapping(path = "/admin_orders", method = RequestMethod.GET)
    public Object goToOrdersAdminPage(){
        return "admin_orders";
    }
    @RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public Object goToDashboardAdminPage(){
        return "admin_dashboard";
    }

}
