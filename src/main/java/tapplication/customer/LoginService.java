package tapplication.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.customer.dao.CustomerDaoImpl;
import tapplication.customer.role.dao.RoleDaoImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 23.03.17.
 */
@Service
public class LoginService {
    List<Customer> allCustomers = new ArrayList<Customer>();

    @Autowired
    private CustomerDaoImpl customerDao;

    @Autowired
    private RoleDaoImpl roleDao;

    @PostConstruct
    public void init() {
        allCustomers = customerDao.findAll();
    }

    public Customer register(Customer newCustomer) {
        newCustomer.setRole(roleDao.findById(1L));
        allCustomers.add(customerDao.save(newCustomer));
        return newCustomer;
    }

    public boolean isAlreadyExist(Customer newCustomer) {
        boolean isExists = false;
        for (Customer customer : allCustomers)
            if (customer.getEmail().equals(newCustomer.getEmail()) && !isExists) {
                isExists = true;
            }
        return isExists;
    }

    public boolean validatePassword(String email, String password) {
        boolean isValid = false;

        for (Customer customer : allCustomers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password) && !isValid) {
                isValid = true;
            }
        }
        return isValid;
    }

    public Customer getCustomerByEmail(String email) {

        for (Customer customer : allCustomers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public boolean validateEmail(String email) {
        boolean isFound = false;
        for (Customer customer : allCustomers) {
            if (customer.getEmail().equals(email) && !isFound) {
                isFound = true;
            }
        }
        return isFound;
    }
}
