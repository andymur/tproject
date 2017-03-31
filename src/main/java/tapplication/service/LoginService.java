package tapplication.service;

import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Customer;
import tapplication.model.Role;

/**
 * Created by alexpench on 31.03.17.
 */
public interface LoginService {
    Customer create(String name, String email, String password, Role role) throws AlreadyExistException;
}
