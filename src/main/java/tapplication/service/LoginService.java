package tapplication.service;

import tapplication.exceptions.AlreadyExistException;
import tapplication.model.Customer;

/**
 * Created by alexpench on 31.03.17.
 */
public interface LoginService {
    Customer create(Customer customer) throws AlreadyExistException;
}
