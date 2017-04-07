package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.service.BasketServiceImpl;

/**
 * Created by alexpench on 06.04.17.
 */
@RestController
@RequestMapping(value = "basket")
public class BasketController {
    @Autowired
    private BasketServiceImpl basketService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody BasketProductDto productToBasket) throws NotFoundException {
        basketService.addProducts(productToBasket);
    }

}
