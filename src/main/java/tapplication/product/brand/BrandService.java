package tapplication.product.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;

import java.util.List;

/**
 * Created by alexpench on 30.03.17.
 */
@Service("brandService")
public class BrandService {
    @Autowired
    private BrandDao brandDao;

    @Transactional
    public Brand createBrand(Brand brand) throws AlreadyExistException {
        if (brandDao.isBrandExist(brand.getName())) {
            throw new AlreadyExistException();
        }
        brandDao.persist(brand);
        return brand;
    }

    public List<Brand> findAll() {
        return brandDao.selectAll();
    }

    @Transactional
    public Brand updateBrand(Brand brand) throws NotFoundException {
        Brand brandToBeMerged = brandDao.find(brand.getId());
        if (brandToBeMerged != null) {
            brandDao.merge(brand);
        } else {
            throw new NotFoundException();
        }
        return brand;
    }

    @Transactional
    public void delete(Brand brand) throws NotFoundException {
        Brand brandToBeDeleted = brandDao.find(brand.getId());
        if (brandToBeDeleted != null) {
            brandDao.delete(brandToBeDeleted);
        } else {
            throw new NotFoundException();
        }
    }
}
