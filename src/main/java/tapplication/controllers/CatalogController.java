package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Brand;
import tapplication.model.Product;
import tapplication.service.ProductService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
@RequestMapping(value = "catalog")
public class CatalogController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Object getCatalogPage(@RequestParam(value = "categoryId") Long categoryId,
                                 Model model) throws NotFoundException {
        List<Product> products = productService.getProductsByCategoryId(categoryId);

        Set<String> sizes = new HashSet<>();
        Set<String> colors = new HashSet<>();
        Set<Brand> brands = new HashSet<>();

        products.forEach(pr -> pr.getParameters().forEach(par -> sizes.add(par.getSize())));
        products.forEach(pr -> colors.add(pr.getColor()));
        products.forEach(pr -> brands.add(pr.getBrand()));
        model.addAttribute("products", products);
        model.addAttribute("colors", colors);
        model.addAttribute("brands", brands);
        model.addAttribute("sizes", sizes);

        return "category";
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
