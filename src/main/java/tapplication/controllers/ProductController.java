package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.service.CategoryServiceImpl;
import tapplication.service.ProductServiceImpl;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by alexpench on 30.03.17.
 */
@Controller
public class ProductController extends CoreController{
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @ResponseBody
    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto newProduct) throws AlreadyExistException {
        return productService.create(newProduct);
    }

    @RequestMapping(path = "product/{id}")
    public Object getProductPage(@PathVariable("id") String id, Model model){
        ProductDto product = productService.findOneDto(Long.parseLong(id));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(path = "product/edit/{id}", method = RequestMethod.GET)
    public Object getProductToEdit(@PathVariable("id") String id, Model model){
        ProductDto product = productService.findOneDto(Long.parseLong(id));
        model.addAttribute("categoriesmap", categoryService.getCategoryMap());
        model.addAttribute("product", product);
        return "productedit";
    }

    @RequestMapping(path = "product/update", method = RequestMethod.POST)
    public void getProductToUpdate(@RequestBody ProductDto productDto, HttpServletResponse resp){
        productService.update(productDto);
        resp.setStatus(200);
    }
}
