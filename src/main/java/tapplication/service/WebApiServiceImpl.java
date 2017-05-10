package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.dto.AdProductDto;
import tapplication.exceptions.AlreadyExistException;
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
    @Autowired
    private AdProductDao adProductDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private MessageSender sender;

    public List<AdProductDto> getProducts() {
        return adProductDao.selectAll().stream().map(adProduct -> new AdProductDto(adProduct.getProduct())).collect(Collectors.toList());
    }

    public void add(Long productId) {

        Product product = productDao.findOne(productId);
        if (adProductDao.isExist(product)) {
            throw new AlreadyExistException();
        }
        AdProduct adProduct = new AdProduct();
        adProduct.setProduct(product);
        adProductDao.persist(adProduct);
        sender.sendMessage(DO_UPDATE);
    }

    @Override
    public void addAll(List<AdProduct> products) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void removeOne(AdProduct product) {

    }

}
