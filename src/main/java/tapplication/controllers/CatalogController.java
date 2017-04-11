package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Product;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductService;

import java.util.List;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
@RequestMapping(value = "catalog")
public class CatalogController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public Object getCatalogPage(@RequestParam(value = "categoryId") Long categoryId,
                                 Model model) throws NotFoundException {
        model.addAttribute("products", productService.getProductsByCategoryId(categoryId));
        model.addAttribute("colors", productService.getColors());
        model.addAttribute("brands", productService.getBrands());
        model.addAttribute("sizes", productService.getSizes());
        model.addAttribute("category", categoryService.getCategoryDtoById(categoryId));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());

        return "catalog";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public Object getFilteredData(
            @RequestParam(value = "categoryId") Long categoryId,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "size", required = false) String size,
                                 Model model) throws NotFoundException {
        List<Product> products = productService.findAllByParams(categoryId,brand,color,size);
        model.addAttribute("products", products);
        return "filtered";
    }
}
