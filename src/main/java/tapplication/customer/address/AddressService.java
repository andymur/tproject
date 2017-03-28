package tapplication.customer.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapplication.customer.address.dao.AddressDaoImpl;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class AddressService {
    @Autowired
    private AddressDaoImpl addressDao;

    public Address addAddress(Address address) {
       return  addressDao.save(address);
    }
}
