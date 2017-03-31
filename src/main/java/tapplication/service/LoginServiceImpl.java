package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public Customer create(String name, String email, String password, Role role) throws AlreadyExistException{

        Customer customer = new Customer(name, email, password, role);

        if (customerDao.isUserExsist(customer.getEmail())) {
            throw new AlreadyExistException();
        }
        customerDao.persist(customer);
        return customer;
    }
}
