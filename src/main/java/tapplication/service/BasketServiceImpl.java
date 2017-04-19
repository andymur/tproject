package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.BasketProductDto;
import tapplication.exceptions.NotFoundException;
import tapplication.model.BasketProduct;
import tapplication.model.User;
import tapplication.repositories.BasketDao;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 06.04.17.
 */
@Service("basketService")
public class BasketServiceImpl {
    public static final String PRODUCT = "product";
    public static final String USER = "user";
    @Autowired
    private BasketDao basketDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserServiceImpl userService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BasketProductDto addProducts(BasketProductDto productDto) throws NotFoundException {

        BasketProduct basketProduct = returnIfExist(productDto);
        if (basketProduct != null) {
            basketProduct.setQuantity(productDto.getQuantity() + basketProduct.getQuantity());
            basketDao.merge(basketProduct);
        } else {
            BasketProduct newBasketProduct = new BasketProduct();
            newBasketProduct.setProduct(productService.findOne(productDto.getProductId()));
            newBasketProduct.setUser(userService.findById(productDto.getUserId()));
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
                    .findOneByAndParams(PRODUCT, productToBasket.getProductId(), USER, productToBasket.getUserId());
        } catch (NoResultException e) {
            return null;
        }
        return basketProduct;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BasketProduct findOne(Long id) throws NotFoundException {
        return basketDao.findOne(id);
    }

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
    public List<BasketProductDto> findBasketProducts(String userName) {
        User user = userService.findBySSO(userName);
        List<BasketProductDto> basketProductDetails = new ArrayList<>();
        List<BasketProduct> basketProducts = findByUserId(user.getId());
        if (!basketProducts.isEmpty()) {
            basketProducts
                    .forEach(basketProduct -> basketProductDetails
                            .add(new BasketProductDto(
                                            basketProduct.getId(),
                                            basketProduct.getProduct().getName(),
                                            basketProduct.getQuantity(),
                                            basketProduct.getUser().getId(),
                                            basketProduct.getProduct().getId()
                                    )
                            )
                    );
        }
        return basketProductDetails;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    private List<BasketProduct> findByUserId(Long userId) {
        List<BasketProduct> basketProducts = basketDao.find("user", userId);
        return basketProducts;
    }

//    public void cleanBasket(OrderDto orderDto) {
//        orderDto.getBasketDto().getRows().forEach(basketProductDto -> {
//            try {
//                remove(basketProductDto);
//            } catch (NotFoundException e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
