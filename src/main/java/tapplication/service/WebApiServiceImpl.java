package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.dto.AdProductDto;
import tapplication.dto.ProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.AdProduct;
import tapplication.model.Product;
import tapplication.repositories.AdProductDao;
import tapplication.repositories.ProductDao;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Service("webApiService")
@Transactional
public class WebApiServiceImpl implements WebApiService {
    public static final String DO_UPDATE = "doUpdate";
    public static final String PRODUCT = "product";

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdProductDao adProductDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private MessageSender sender;

    public List<AdProductDto> getProducts() {
        return adProductDao.selectAll().stream().map(adProduct -> new AdProductDto(adProduct.getProduct())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getPromoList() {
        return adProductDao.selectAll().stream().map(adProduct -> new ProductDto(adProduct.getProduct())).collect(Collectors.toList());
    }

    public void add(Long productId) {

        Product product = productDao.findOne(productId);
        if (adProductDao.isExist(product)) {
            throw new AlreadyExistException();
        }
        AdProduct adProduct = new AdProduct();
        adProduct.setProduct(product);
        adProductDao.persist(adProduct);
        logger.info("Product id: {}, name: {} has been added to promo list.", product.getId(), product.getName());
        sender.sendMessage(DO_UPDATE);
        logger.info("Message {} to promo client has been sent.", DO_UPDATE);
    }

    @Override
    public void addAll(List<AdProduct> products) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void removeOne(AdProductDto adProductDto) {

        AdProduct adProduct = adProductDao.findOne(PRODUCT, adProductDto.getProductId());

        if(adProduct == null){
            logger.warn("Product id:{} was not found in database", adProductDto.getProductId());
            throw new NotFoundException();
        }

        adProductDao.delete(adProduct);
        logger.info("Product id:{}, name:{} has been removed from promo list.",adProduct.getProduct().getId(), adProduct.getProduct().getName());
        sender.sendMessage(DO_UPDATE);
        logger.info("Message {} to promo client has been sent.", DO_UPDATE);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDao.selectAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
