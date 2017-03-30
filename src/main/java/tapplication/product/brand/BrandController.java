package tapplication.product.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;

/**
 * Created by alexpench on 30.03.17.
 */
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "brand/create")
    public Object createBrand(@RequestBody Brand brand) throws AlreadyExistException {
        Brand newBrand = brandService.createBrand(brand);
        return newBrand;
    }

    @RequestMapping(value = "brand")
    public Object findAll() {
        return brandService.findAll();
    }

    @RequestMapping(value = "brand/update")
    public Object updateBrand(@RequestBody Brand brand) throws NotFoundException {
        return brandService.updateBrand(brand);
    }

    @RequestMapping(value = "brand/delete")
    public void deleteBrand(@RequestBody Brand brand) throws NotFoundException {
         brandService.delete(brand);
    }
}
