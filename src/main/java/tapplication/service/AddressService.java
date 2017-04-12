package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.DeliveryAddressDto;
import tapplication.dto.OrderDto;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Address;
import tapplication.repositories.AddressDao;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AddressService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserService userService;

    public Address findOne(Long deliveryAddressId) throws NotFoundException {
        Address address = addressDao.findOne(deliveryAddressId);
        if (address == null) {
            throw new NotFoundException();
        }
        return address;
    }

    public Address save(OrderDto orderDto) {
        DeliveryAddressDto deliveryAddress = orderDto.getDeliveryAddressDto();
        Address address = new Address();
        address.setCountry(deliveryAddress.getCountry());
        address.setCity(deliveryAddress.getCity());
        address.setStreet(deliveryAddress.getStreet());
        address.setBuilding(deliveryAddress.getBuilding());
        address.setApartment(deliveryAddress.getApartment());
        address.setZipCode(deliveryAddress.getZipCode());
        address.setUser(userService.findById(orderDto.getUserId()));
        addressDao.persist(address);
        return address;
    }

//    public Address findUserAddress(String ssoId) {
//        Address address = new Address();
//        List<Address> = userService.findBySSO(ssoId).getAddresses();
//        try {
//            addressDao.findOne(Address.USER_ENTITY, userId);
//        }catch (NoResultException e){
//            address = null;
//        }
//        return address;
//    }
}
