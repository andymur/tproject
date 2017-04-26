package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.dto.AddressDto;
import tapplication.service.AddressService;
import tapplication.service.DataHelperService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by alexpench on 26.03.17.
 */
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private DataHelperService dataHelperService;

    @RequestMapping(path = "address")
    public Object addProducts(Model model) {
        model.addAttribute("addresses", addressService.findUserAddress());
        model.addAttribute("categoriesmap", dataHelperService.getCategoryMap());
        model.addAttribute("loggedinuser", dataHelperService.getUserName());
        return "address";
    }

    @RequestMapping(path = "addresses", method = RequestMethod.GET)
    public Object getUserAddresses(Model model) {
        model.addAttribute("addresses", addressService.findUserAddress());
        return "addresses";
    }

    @RequestMapping(path = "address/create", method = RequestMethod.POST)
    public void create(@RequestBody AddressDto addressDto, HttpServletResponse resp) {
        addressService.save(addressDto);
        resp.setStatus(200);
    }
}
