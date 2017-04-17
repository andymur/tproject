package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Product;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductService;

/**
 * Created by alexpench on 30.03.17.
 */
@Controller
public class ProductController extends CoreController{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @ResponseBody
    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    public Object createProduct(@RequestBody Product newProduct) throws AlreadyExistException {
        Product product = productService.create(newProduct);
        return product;
    }

    @RequestMapping(path = "product/{id}")
    public Object getProductPage(@PathVariable("id") String id, Model model){
        ProductDto product = productService.findOneDto(Long.parseLong(id));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("product", product);
        return "product";
    }
}
