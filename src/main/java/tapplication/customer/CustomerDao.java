package tapplication.customer;

import org.springframework.stereotype.Repository;
import tapplication.dao.AbstractDao;

import javax.persistence.Id;

/**
 * Created by alexpench on 25.03.17.
 */

@Repository("customerDao")
public class CustomerDao extends AbstractDao<Customer, Id>{

    public CustomerDao() {
        super(Customer.class);
    }

    @Override
    public void persist(Customer user) {
        super.persist(user);
    }

    public boolean isUserExsist(String email) {
        return count("email", email) != 0;
    }
}
