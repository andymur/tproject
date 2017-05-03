package tapplication.service;

import tapplication.dto.AdProductDto;
import tapplication.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by apenchukov on 5/3/2017.
 */
@Path("/productslist")
public interface WebApiService {
    @GET
    List<AdProductDto> getProducts();

    void add(Product product);

    void addAll(List<Product> products);

    void clean();

    void removeOne(Product product);
}
