package tapplication.customer.dao;

import tapplication.customer.Customer;

import java.util.List;

/**
 * Created by alexpench on 25.03.17.
 */
public interface CustomerDao {
    public List<Customer> findAll();

    public Customer findByEmail(String email);

    public Customer save(Customer customer);

    public void update(Customer customer);

    public void delete(Customer contact);
}
