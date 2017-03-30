package tapplication.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapplication.customer.role.Role;
import tapplication.customer.role.dao.RoleDao;
import tapplication.exceptions.AlreadyExistException;

/**
 * Created by alexpench on 23.03.17.
 */
@Service
public class LoginService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Customer save(String name, String email, String password, Role role) throws AlreadyExistException{

        Customer customer = new Customer(name, email, password, role);

        if (customerDao.isUserExsist(customer.getEmail())) {
            throw new AlreadyExistException();
        }
        customerDao.persist(customer);
        return customer;
    }
}
