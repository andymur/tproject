package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Parameters;

/**
 * Created by alexpench on 01.04.17.
 */
@Repository
public class ParametersDao extends AbstractDao<Parameters, Long>{

    public ParametersDao() {
        super(Parameters.class);
    }


    public boolean isExist(String size, Long weight) {
        return count(Parameters.SIZE, size, Parameters.WEIGHT, weight) > 0;
    }
}
