package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Customer;

import javax.persistence.Id;
import javax.persistence.Query;

/**
 * Created by alexpench on 25.03.17.
 */

@Repository("customerDao")
public class CustomerDao extends AbstractDao<Customer, Long> {

    public CustomerDao() {
        super(Customer.class);
    }

    @Override
    public void persist(Customer user) {
        super.persist(user);
    }

    public boolean isExsist(String email) {
        return count("email", email) != 0;
    }

    public boolean validate(Customer customer) {
        return (count(Customer.EMAIL, customer.getEmail()) != 0 || count(Customer.PASSWORD, customer.getPassword()) != 0);
    }

    public Customer findByEmail(Customer customer) {
        return (Customer) super.getEntityManager().createQuery(
                "Select c from Customer c where c.email = :email and c.password = :password)")
                        .setParameter("email", customer.getEmail())
                        .setParameter("password", customer.getPassword()).getSingleResult();
    }
}
