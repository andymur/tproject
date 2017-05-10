package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.AdProductDto;
import tapplication.model.AdProduct;
import tapplication.service.WebApiService;

import java.util.List;

/**
 * Created by apenchukov on 5/5/2017.
 */
@Controller
public class WebServiceController {
    @Autowired
    private WebApiService webApiService;

    @ResponseBody
    @RequestMapping(path = "/productslist", method = RequestMethod.GET)
    public List<AdProductDto> getAdProducts(){
        return webApiService.getProducts();
    }

    @RequestMapping(path = "/promo", method = RequestMethod.GET)
    public Object getPromoPage(Model model){
        model.addAttribute("products", webApiService.getProducts());
        return "promo";
    }

    @RequestMapping(value = "/productslist/add",method = RequestMethod.POST)
    public void addAdProduct(@RequestBody AdProductDto adProductDto){
        webApiService.add(adProductDto.getProductId());
    }
}
