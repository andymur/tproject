package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.ProductImage;
import tapplication.repositories.ProductImageDao;

import java.util.List;

/**
 * Created by alexpench on 31.03.17.
 */
@Service("productImageService")
public class ProductImageServiceImpl implements CoreService<ProductImage> {
    @Autowired
    private ProductImageDao productImageDao;

    public ProductImage findOne(Long id) throws NotFoundException {
        return productImageDao.find(id);
    }

    @Transactional
    public ProductImage create(ProductImage productImage) throws AlreadyExistException{
        if (productImageDao.isExist(productImage.getName())) {
           throw new AlreadyExistException();
        }
        productImageDao.persist(productImage);
        return productImage;
    }

    @Transactional
    public ProductImage update(ProductImage productImage) throws NotFoundException {
        ProductImage imageToBeMerged = productImageDao.find(productImage.getId());
        if (imageToBeMerged != null) {
            productImageDao.merge(productImage);
        } else {
            throw new NotFoundException();
        }
        return productImage;
    }

    @Transactional
    public void delete(ProductImage productImage) throws NotFoundException {
        ProductImage imageToBeDeleted = productImageDao.find(productImage.getId());
        if (imageToBeDeleted != null) {
            productImageDao.delete(imageToBeDeleted);
        } else {
            throw new NotFoundException();
        }
    }

    public List<ProductImage> findAll() {
        return productImageDao.selectAll();
    }
}
