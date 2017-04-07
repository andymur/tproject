package tapplication.service;

import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Customer;

/**
 * Created by alexpench on 31.03.17.
 */
public interface CustomerService {
    Customer create(Customer customer) throws AlreadyExistException;

    Customer findOne(Long customerId) throws NotFoundException;
}
