package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Product;
import tapplication.service.ProductService;

/**
 * Created by alexpench on 30.03.17.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    public Object createProduct(@RequestBody Product newProduct) throws AlreadyExistException {
        Product product = productService.create(newProduct);
        return product;
    }
}
