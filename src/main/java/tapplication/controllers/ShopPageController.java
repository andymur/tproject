package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductService;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
@RequestMapping(value = "shop")
public class ShopPageController extends CoreController{
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private ProductService productService;
@RequestMapping(method = RequestMethod.GET)
    public Object redirect(Model model) {
    model.addAttribute("loggedinuser", getPrincipal());
    model.addAttribute("categoriesmap", categoryService.getCategoryMap());
    model.addAttribute("products", productService.getAllProductsDtoList());
    return "shop";
    }
}
