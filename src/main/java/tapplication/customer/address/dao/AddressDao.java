package tapplication.customer.address.dao;

import tapplication.customer.address.Address;

import java.util.List;

/**
 * Created by alexpench on 26.03.17.
 */
public interface AddressDao {
    public Address save(Address address);
    public List<Address> getAllByCustomerId(Long id);
    public void update(Address address);
}
