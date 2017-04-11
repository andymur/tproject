package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.service.BrandServiceImpl;
import tapplication.service.CategoryServiceImpl;

/**
 * Created by alexpench on 02.04.17.
 */
@Controller
public class ProductsAdminController extends CoreController{
    @Autowired
    private BrandServiceImpl brandService;

    @Autowired
    private CategoryServiceImpl categoryService;
    @RequestMapping(path = "/admin_products", method = RequestMethod.GET)
    public Object goToProductsAdminPage(Model model){
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        return  "admin_products";
    }
}
