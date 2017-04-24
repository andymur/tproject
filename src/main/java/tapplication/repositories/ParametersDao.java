package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Parameters;
import tapplication.model.Product;

/**
 * Created by alexpench on 01.04.17.
 */
@Repository
public class ParametersDao extends AbstractDao<Parameters, Long>{

    public ParametersDao() {
        super(Parameters.class);
    }

    public boolean isExist(String size, Long weight, Product product) {
        return super.findAllByAndParams(Parameters.SIZE, size, Parameters.WEIGHT, weight, "product", product).size() > 0;
    }
}
