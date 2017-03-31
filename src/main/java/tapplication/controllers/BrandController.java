package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Brand;
import tapplication.service.BrandServiceImpl;

/**
 * Created by alexpench on 30.03.17.
 */
@RestController
public class BrandController {
    @Autowired
    private BrandServiceImpl brandService;

    @RequestMapping(value = "brand/create")
    public Object createBrand(@RequestBody Brand brand) throws AlreadyExistException {
        Brand newBrand = brandService.create(brand);
        return newBrand;
    }

    @RequestMapping(value = "brand")
    public Object findAll() {
        return brandService.findAll();
    }

    @RequestMapping(value = "brand/update")
    public Object updateBrand(@RequestBody Brand brand) throws NotFoundException {
        return brandService.update(brand);
    }

    @RequestMapping(value = "brand/delete")
    public void deleteBrand(@RequestBody Brand brand) throws NotFoundException {
         brandService.delete(brand);
    }
}
