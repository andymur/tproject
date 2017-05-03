package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import tapplication.dto.AdProductDto;
import tapplication.model.Product;
import tapplication.repositories.AdProductDao;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Transactional
public class WebApiServiceImpl implements WebApiService {
    @Autowired
    private AdProductDao adProductDao;

    @Override
    @ResponseBody
    public List<AdProductDto> getProducts() {
        return adProductDao.selectAll().stream().map(adProduct -> new AdProductDto(adProduct.getProduct())).collect(Collectors.toList());
    }

    @Override
    public void add(Product product) {
        
    }

    @Override
    public void addAll(List<Product> products) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void removeOne(Product product) {

    }


}
