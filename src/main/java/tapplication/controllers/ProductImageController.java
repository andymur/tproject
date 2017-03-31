package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.ProductImage;
import tapplication.service.ProductImageServiceImpl;

/**
 * Created by alexpench on 31.03.17.
 */
@RestController
public class ProductImageController {
    @Autowired
    private ProductImageServiceImpl productImageService;

    @RequestMapping(value = "product/image/create")
    public Object create(@RequestBody ProductImage productImage) throws AlreadyExistException {
        ProductImage newProductImage = productImageService.create(productImage);
        return newProductImage;
    }

    @RequestMapping(value = "product/images")
    public Object findAll() {
        return productImageService.findAll();
    }

    @RequestMapping(value = "product/image/update")
    public Object update(@RequestBody ProductImage productImage) throws NotFoundException {
        return productImageService.update(productImage);
    }

    @RequestMapping(value = "product/image/delete")
    public void delete(@RequestBody ProductImage productImage) throws NotFoundException {
        productImageService.delete(productImage);
    }
}
