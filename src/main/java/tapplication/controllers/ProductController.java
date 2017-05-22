package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tapplication.dto.ParametersDto;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.service.DataHelperService;
import tapplication.service.ParametersServiceImpl;
import tapplication.service.ProductServiceImpl;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexpench on 30.03.17.
 */
@Controller
public class ProductController extends CoreController{
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DataHelperService dataHelperService;

    @Autowired
    private ParametersServiceImpl parametersService;

    @ResponseBody
    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto newProduct) throws AlreadyExistException {
        return productService.create(newProduct);
    }

    @RequestMapping(path = "product/{id}")
    public Object getProductPage(@PathVariable("id") String id, Model model){
        ProductDto product = productService.findOneDto(Long.parseLong(id));
        model.addAttribute("categoriesmap", dataHelperService.getCategoryMap());
        model.addAttribute("loggedinuser", dataHelperService.getUserName());
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(path = "product/edit/{id}", method = RequestMethod.GET)
    public Object getProductToEdit(@PathVariable("id") String id, Model model){
        ProductDto product = productService.findOneDto(Long.parseLong(id));
        model.addAttribute("categoriesmap", dataHelperService.getCategoryMap());
        model.addAttribute("product", product);
        return "productedit";
    }

    @RequestMapping(path = "product/update", method = RequestMethod.POST)
    public void getProductToUpdate(@RequestBody ProductDto productDto, HttpServletResponse resp){
        productService.update(productDto);
        resp.setStatus(200);
    }

    @RequestMapping(path = "product/parameters/add", method = RequestMethod.POST)
    public void add(@RequestBody ParametersDto parametersDto, HttpServletResponse response) {
        parametersService.add(parametersDto);
        response.setStatus(200);
    }

    @ExceptionHandler(NoResultException.class)
    @ResponseBody()
    public String handleNoResultException(NoResultException ex, HttpServletResponse response) throws IOException {
        response.setStatus(404);
        return ex.getMessage();
    }
}
