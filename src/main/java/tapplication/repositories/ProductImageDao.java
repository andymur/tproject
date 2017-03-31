package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.ProductImage;

/**
 * Created by alexpench on 31.03.17.
 */
@Repository
public class ProductImageDao extends AbstractDao<ProductImage, Long> {

    public ProductImageDao() {
        super(ProductImage.class);
    }

    public boolean isExist(String name) {
        return count(ProductImage.NAME, name) != 0;
    }
}
