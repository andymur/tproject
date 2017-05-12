package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tapplication.dto.AdProductDto;
import tapplication.service.WebApiService;

import javax.servlet.http.HttpServletResponse;
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
        model.addAttribute("products", webApiService.getPromoList());
        model.addAttribute("allProducts", webApiService.getAllProducts());
        return "promo";
    }

    @RequestMapping(value = "/productslist/add",method = RequestMethod.POST)
    public void addAdProduct(@RequestBody AdProductDto adProductDto, HttpServletResponse resp){
        webApiService.add(adProductDto.getProductId());
        resp.setStatus(200);
    }

    @RequestMapping(value = "/productslist/remove",method = RequestMethod.POST)
    public void removeAdProduct(@RequestBody AdProductDto adProductDto, HttpServletResponse resp){
        webApiService.removeOne(adProductDto);
        resp.setStatus(200);
    }
}
