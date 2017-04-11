package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.controllers.dto.BasketDto;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.service.BasketServiceImpl;
import tapplication.service.ProductService;

/**
 * Created by alexpench on 06.04.17.
 */
@Controller
@RequestMapping(value = "basket")
public class BasketController extends CoreController {
    @Autowired
    private BasketServiceImpl basketService;
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public Object getBasket(@RequestBody BasketDto basketDto, Model model){
        model.addAttribute("products", productService.getProductsForBasket(basketDto));
        return "basket";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody BasketProductDto productToBasket) throws NotFoundException {
        basketService.addProducts(productToBasket);
        return basketService.findBasketProducts(getPrincipal());
    }


    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void remove(@RequestBody BasketProductDto productDto) throws NotFoundException {
        basketService.remove(productDto);
    }
}
