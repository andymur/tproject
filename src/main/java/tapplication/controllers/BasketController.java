package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.dto.BasketProductDto;
import tapplication.dto.ProductAndAmount;
import tapplication.exceptions.NotFoundException;
import tapplication.service.BasketServiceImpl;
import tapplication.service.DataHelperService;

import java.util.List;

/**
 * Created by alexpench on 06.04.17.
 */
@Controller
@RequestMapping(value = "basket")
public class BasketController{
    @Autowired
    private BasketServiceImpl basketService;
    @Autowired
    private DataHelperService dataHelperService;

    @RequestMapping(method = RequestMethod.POST)
    public Object getBasket(@RequestBody List<ProductAndAmount> basketProducts, Model model){
        model.addAttribute("products", dataHelperService.getProducts(basketProducts));
        return "basket";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody BasketProductDto productToBasket) throws NotFoundException {
        basketService.addProducts(productToBasket);
        return basketService.findBasketProducts(dataHelperService.getUserName());
    }


    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void remove(@RequestBody BasketProductDto productDto) throws NotFoundException {
        basketService.remove(productDto);
    }
}
