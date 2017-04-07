package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Address;

/**
 * Created by alexpench on 07.04.17.
 */
@Repository
public class AddressDao extends AbstractDao<Address, Long> {
    public AddressDao() {
        super(Address.class);
    }
}
