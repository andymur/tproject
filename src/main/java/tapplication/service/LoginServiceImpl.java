package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.InvalidDataException;
import tapplication.model.Customer;
import tapplication.repositories.CustomerDao;
import tapplication.model.Role;
import tapplication.repositories.RoleDao;
import tapplication.exceptions.AlreadyExistException;

/**
 * Created by alexpench on 23.03.17.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Customer create(Customer customer) throws AlreadyExistException{

        customer.setRole(new Role(1l));
        if (customerDao.isExsist(customer.getEmail())) {
            throw new AlreadyExistException();
        }
        customerDao.persist(customer);
        return customer;
    }

    @Transactional
    public Customer getCustomerByEmail(Customer customer) throws InvalidDataException {

        if(!isValid(customer)){
            throw new InvalidDataException();
        }
        return customerDao.findByEmail(customer);
    }

    public boolean isValid(Customer customer) {
        return customerDao.validate(customer);
    }
}
