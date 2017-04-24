package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tapplication.dto.ProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductServiceImpl;

import java.util.List;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
@RequestMapping(value = "catalog")
public class CatalogController extends CoreController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public Object getCatalogPage(@RequestParam(value = "categoryId") Long categoryId,
                                 Model model) throws NotFoundException {
        List<ProductDto> products = productService.getProductsByCategoryId(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("colors", productService.getColors(products));
        model.addAttribute("brands", productService.getBrands(products));
        model.addAttribute("sizes", productService.getSizes(products));
        model.addAttribute("category", categoryService.getCategoryDtoById(categoryId));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("loggedinuser", getPrincipal());

        return "catalog";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public Object getFilteredData(
            @RequestParam(value = "categoryId") Long categoryId,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "size", required = false) String size,
                                 Model model) throws NotFoundException {
        List<ProductDto> products = productService.findAllByParams(categoryId,brand,color,size);
        model.addAttribute("products", products);
        model.addAttribute("color", color);
        model.addAttribute("brand", brand);
        model.addAttribute("size", size);
        model.addAttribute("category", categoryService.getCategoryDtoById(categoryId));
        model.addAttribute("colors", productService.getColors(products));
        model.addAttribute("brands", productService.getBrands(products));
        model.addAttribute("sizes", productService.getSizes(products));
        return "filtered";
    }
}
