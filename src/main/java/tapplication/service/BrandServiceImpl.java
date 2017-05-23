package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Brand;
import tapplication.repositories.BrandDao;

import java.util.List;

/**
 * Created by alexpench on 30.03.17.
 */
@Service("brandService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class BrandServiceImpl implements CoreService<Brand> {

    @Autowired
    private BrandDao brandDao;

    public Brand findOne(Long id) throws NotFoundException {
        return brandDao.findOne(id);
    }


    public Brand create(Brand brand) throws AlreadyExistException {
        if (brandDao.isBrandExist(brand.getName())) {
            throw new AlreadyExistException();
        }
        brandDao.persist(brand);
        return brand;
    }

    public List<Brand> findAll() {
        return brandDao.selectAll();
    }

    public Brand update(Brand brand) throws NotFoundException {
        Brand brandToBeMerged = brandDao.findOne(brand.getId());
        if (brandToBeMerged != null) {
            brandDao.merge(brand);
        } else {
            throw new NotFoundException();
        }
        return brand;
    }

    public void delete(Brand brand) throws NotFoundException {
        Brand brandToBeDeleted = brandDao.findOne(brand.getId());
        if (brandToBeDeleted != null) {
            brandDao.delete(brandToBeDeleted);
        } else {
            throw new NotFoundException();
        }
    }
}
