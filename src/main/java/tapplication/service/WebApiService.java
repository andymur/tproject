package tapplication.service;

import tapplication.dto.AdProductDto;
import tapplication.model.AdProduct;
import tapplication.model.Product;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by apenchukov on 5/3/2017.
 */

public interface WebApiService {
    List<AdProductDto> getProducts();

    void add(Long id);

    void addAll(List<AdProduct> products);

    void clean();

    void removeOne(AdProduct product);
}
