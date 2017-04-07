package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.controllers.dto.BasketProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.model.BasketProduct;
import tapplication.repositories.BasketDao;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 06.04.17.
 */
@Service("basketService")
public class BasketServiceImpl {
    @Autowired
    private BasketDao basketDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerServiceImpl customerService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BasketProductDto addProducts(BasketProductDto productDto) throws NotFoundException {

        BasketProduct basketProduct = returnIfExist(productDto);
        if (basketProduct != null) {
            basketProduct.setQuantity(productDto.getQuantity() + basketProduct.getQuantity());
            basketDao.merge(basketProduct);
        } else {
            BasketProduct newBasketProduct = new BasketProduct();
            newBasketProduct.setProduct(productService.findOne(productDto.getProductId()));
            newBasketProduct.setCustomer(customerService.findOne(productDto.getCustomerId()));
            newBasketProduct.setQuantity(productDto.getQuantity());
            basketDao.persist(newBasketProduct);
        }
        return productDto;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    private BasketProduct returnIfExist(BasketProductDto productToBasket) {
        BasketProduct basketProduct;
        try {
            basketProduct = basketDao
                    .findByAndParams("product", productToBasket.getProductId(), "customer", productToBasket.getCustomerId());
        } catch (NoResultException e) {
            return null;
        }
        return basketProduct;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BasketProduct findOne(Long id) throws NotFoundException {
        return basketDao.findOne(id);
    }

//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    public BasketProduct update(BasketProduct entity) throws NotFoundException {
//        BasketProduct basketProduct = findOne(entity.getId());
//        if (basketProduct != null) {
//            basketDao.merge(basketProduct);
//        } else {
//            throw new NotFoundException();
//        }
//        return basketProduct;
//    }

    @Transactional
    public void remove(BasketProductDto basketProductDto) throws NotFoundException {
        BasketProduct basketProduct = basketDao.findOne(basketProductDto.getRecordId());
        if (basketProduct != null) {
            basketDao.delete(basketProduct);
        } else {
            throw new NotFoundException();
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<BasketProductDto> findBasketProducts(Long customerId) {
        List<BasketProductDto> basketProductDetails = new ArrayList<>();
        List<BasketProduct> basketProducts = findByCustomerId(customerId);
        if (!basketProducts.isEmpty()) {
            basketProducts
                    .forEach(basketProduct -> basketProductDetails
                            .add(new BasketProductDto(
                                    basketProduct.getId(),
                                    basketProduct.getProduct().getName(),
                                    basketProduct.getQuantity(),
                                    basketProduct.getCustomer().getId(),
                                    basketProduct.getProduct().getId()
                                    )
                                )
                    );
        }
        return basketProductDetails;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    private List<BasketProduct> findByCustomerId(Long customerId) {
        List<BasketProduct> basketProducts = basketDao.find("customer", customerId);
        return basketProducts;
    }
}
