package tapplication.service;

import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;

import java.util.List;

/**
 * Created by alexpench on 31.03.17.
 */
public interface CoreService<T> {
     T findOne (Long id) throws NotFoundException;
     T create(T entity) throws AlreadyExistException;
     T update(T entity) throws NotFoundException;
     void delete(T entity) throws NotFoundException;
     List<T> findAll();
}
