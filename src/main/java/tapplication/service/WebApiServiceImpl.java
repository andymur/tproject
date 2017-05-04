package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tapplication.dto.AdProductDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.AdProduct;
import tapplication.model.Product;
import tapplication.repositories.AdProductDao;
import tapplication.repositories.ProductDao;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Path("/productslist")
@Produces({ "application/json" })
public class WebApiServiceImpl implements WebApiService {
    @Autowired
    private AdProductDao adProductDao;
    @Autowired
    private ProductDao productDao;
    private static List<AdProductDto> products = new ArrayList<>();

    @GET
    public Object getProducts() {
        return products;
//        return adProductDao.selectAll().stream().map(adProduct -> new AdProductDto(adProduct.getProduct())).collect(Collectors.toList());
    }

    @POST
//    @Path("{name}")
    public void add(@QueryParam("name") String name, @QueryParam("price") String price, @QueryParam("imageurl") String imageurl) {
        Long priceLong = Long.parseLong(price);
        if (!products.isEmpty()) {
            products.forEach(p -> {
                if (!p.getName().equals(name)) {
                    products.add(new AdProductDto(name, priceLong, imageurl));
                }
            });
        } else {
            products.add(new AdProductDto(name, priceLong, imageurl));
        }
//        Long productId = Long.parseLong(id);
        //        Product product = productDao.findOne(productId);
//        if (adProductDao.isExist(product)) {
//            throw new AlreadyExistException();
//        }
//        AdProduct adProduct = new AdProduct();
//        adProduct.setProduct(product);
//        adProductDao.persist(adProduct);
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
