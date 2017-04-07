package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.InvalidDataException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Customer;
import tapplication.model.Role;
import tapplication.repositories.CustomerDao;
import tapplication.repositories.RoleDao;

/**
 * Created by alexpench on 23.03.17.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RoleDao roleDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Customer create(Customer customer) throws AlreadyExistException {
        customer.setRole(new Role(1l));
        if (customerDao.isExsist(customer.getEmail())) {
            throw new AlreadyExistException();
        }
        customerDao.persist(customer);
        return customer;
    }

    public Customer getCustomerByEmail(Customer customer) throws InvalidDataException {
        if (!isValid(customer)) {
            throw new InvalidDataException();
        }
        return customerDao.findByEmail(customer);
    }

    public boolean isValid(Customer customer) {
        return customerDao.validate(customer);
    }

    public Customer findOne(Long customerId) throws NotFoundException {
        Customer customer = customerDao.findOne(customerId);
        if (customer == null) {
            throw new NotFoundException();
        }
        return customer;
    }
}
