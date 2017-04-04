package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tapplication.exceptions.NotFoundException;
import tapplication.service.CatalogServiceImpl;

/**
 * Created by alexpench on 04.04.17.
 */
@Controller
public class CatalogController {
    @Autowired
    private CatalogServiceImpl catalogService;
    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    public Object getCatalogPage(@RequestParam("categoryId") Long categoryId,
                                 @RequestParam("categoryName") String categoryName,
                                 Model model) throws NotFoundException {
        model.addAttribute(categoryName, catalogService.preparePage(model, categoryId));
        return "catalog";
    }
}
