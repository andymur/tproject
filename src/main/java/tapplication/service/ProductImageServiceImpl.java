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
    private ProductImageDao repo;

    public ProductImage findOne(Long id) throws NotFoundException {
        return repo.find(id);
    }

    @Transactional
    public ProductImage create(ProductImage entity) throws AlreadyExistException{
        if (repo.isExist(entity.getName())) {
           throw new AlreadyExistException();
        }
        repo.persist(entity);
        return entity;
    }

    @Transactional
    public ProductImage update(ProductImage productImage) throws NotFoundException {
        ProductImage imageToBeMerged = repo.find(productImage.getId());
        if (imageToBeMerged != null) {
            repo.merge(productImage);
        } else {
            throw new NotFoundException();
        }
        return productImage;
    }

    @Transactional
    public void delete(ProductImage productImage) throws NotFoundException {
        ProductImage imageToBeDeleted = repo.find(productImage.getId());
        if (imageToBeDeleted != null) {
            repo.delete(imageToBeDeleted);
        } else {
            throw new NotFoundException();
        }
    }

    public List<ProductImage> findAll() {
        return repo.selectAll();
    }
}
