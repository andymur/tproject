package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.service.BasketServiceImpl;

import java.util.List;

/**
 * Created by alexpench on 06.04.17.
 */
@RestController
@RequestMapping(value = "basket")
public class BasketController {
    @Autowired
    private BasketServiceImpl basketService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody BasketProductDto productToBasket) throws NotFoundException {
        basketService.addProducts(productToBasket);
        return basketService.findBasketProducts(productToBasket.getCustomerId());
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object getBasket(@RequestParam(value = "customerId") Long customerId){
        List<BasketProductDto> basketProductsDto = basketService.findBasketProducts(customerId);
        return basketProductsDto;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void remove(@RequestBody BasketProductDto productDto) throws NotFoundException {
        basketService.remove(productDto);
    }
}
