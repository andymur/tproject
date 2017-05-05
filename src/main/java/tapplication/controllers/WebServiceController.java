package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.AdProductDto;
import tapplication.model.AdProduct;
import tapplication.service.WebApiService;

import java.util.List;

/**
 * Created by apenchukov on 5/5/2017.
 */
@RestController
@RequestMapping(path = "/productslist")
public class WebServiceController {
    @Autowired
    private WebApiService webApiService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<AdProductDto> getAdProducts(){
        return webApiService.getProducts();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addAdProduct(@RequestBody AdProductDto adProductDto){
        webApiService.add(adProductDto.getProductId());
    }
}
