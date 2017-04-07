package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.BasketProduct;
import tapplication.repositories.BasketDao;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by alexpench on 06.04.17.
 */
@Service("basketService")
public class BasketServiceImpl implements CoreService<BasketProduct> {
    @Autowired
    private BasketDao basketDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerServiceImpl customerService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addProducts(BasketProductDto productToBasket) throws NotFoundException {
        Long productId = productToBasket.getProductId();
        Long customerId = productToBasket.getCustomerId();
        Long quantity = productToBasket.getQuantity();

        BasketProduct newBasketProduct = new BasketProduct();
        newBasketProduct.setProduct(productService.findOne(productId));
        newBasketProduct.setCustomer(customerService.findOne(customerId));
        newBasketProduct.setQuantity(quantity);

        BasketProduct basketProduct = null;
        try {
            basketProduct = basketDao.findOne("product", productId, "customer", customerId);
        } catch (NoResultException e) {
            basketDao.persist(newBasketProduct);
        }
        basketProduct.setQuantity(quantity + basketProduct.getQuantity());
        update(basketProduct);
    }

    @Override
    public BasketProduct findOne(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public BasketProduct create(BasketProduct entity) throws AlreadyExistException {
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public BasketProduct update(BasketProduct entity) throws NotFoundException {
        BasketProduct basketProduct = basketDao.findOne(entity.getId());
        if(basketProduct != null){
            basketDao.merge(basketProduct);
        } else  {
            throw new NotFoundException();
        }
        return basketProduct;
    }

    @Override
    public void delete(BasketProduct entity) throws NotFoundException {

    }

    @Override
    public List<BasketProduct> findAll() {
        return null;
    }
}
