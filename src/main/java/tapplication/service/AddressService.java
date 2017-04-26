package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.AddressDto;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Address;
import tapplication.repositories.AddressDao;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private DataHelperService dataHelperService;

    public Address findOne(Long id){
        Address address = addressDao.findOne(id);
        if (address == null) {
            throw new NotFoundException();
        }
        return address;
    }

    public Address save(AddressDto addressDto) {
        Address address = new Address();
        if (addressDto.getId() != null) {
            address = addressDao.findOne(addressDto.getId());
            setAddressDetails(addressDto, address);

        } else {
            setAddressDetails(addressDto, address);
            address.setUser(userService.findBySSO(dataHelperService.getPrincipal()));
            addressDao.persist(address);
        }
        return address;
    }

    private void setAddressDetails(AddressDto addressDto, Address address) {
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setAppartment(addressDto.getAppartment());
        address.setZipCode(addressDto.getZipCode());
        address.setPhoneNumber(addressDto.getPhoneNumber());
        address.setEmail(addressDto.getEmail());
    }

    public List<AddressDto> findUserAddress() {
        return addressDao.findAllByAndParams(Address.USER_ENTITY, userService.findBySSO(dataHelperService.getPrincipal())).stream()
                .map(AddressDto::new).collect(Collectors.toList());
    }
}
