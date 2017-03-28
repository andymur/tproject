package tapplication.customer.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexpench on 26.03.17.
 */
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(path = "address")
    public Object add(@RequestBody Address address){
        return addressService.addAddress(address);
    }
}
