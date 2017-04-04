package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.service.BrandServiceImpl;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductService;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
@RequestMapping(value = "shop")
public class ShopPageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private BrandServiceImpl brandService;
@RequestMapping(method = RequestMethod.GET)
    public Object redirect() {
        return "shop";
    }
//        model.addAttribute("products", productService.findAll());
//        model.addAttribute("categories", categoryService.findAll());
//        model.addAttribute("brands", brandService.findAll());
}
