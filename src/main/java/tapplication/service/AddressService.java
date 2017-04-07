package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Address;
import tapplication.repositories.AddressDao;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Address findOne(Long deliveryAddressId) throws NotFoundException {
        Address address = addressDao.findOne(deliveryAddressId);
        if(address == null){
            throw new NotFoundException();
        }
        return address;
    }
}
