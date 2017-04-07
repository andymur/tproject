package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Parameters;
import tapplication.repositories.ParametersDao;

import java.util.List;

/**
 * Created by alexpench on 01.04.17.
 */
@Service("parametersService")
public class ParametersServiceImpl{
    @Autowired
    private ParametersDao repo;

    public Parameters findOne(Long id) throws NotFoundException {
        Parameters parameters = repo.findOne(id);
        if (parameters == null) {
            throw new NotFoundException();
        }
        return parameters;
    }

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public Parameters create(String size,Long weight,Long productId) throws AlreadyExistException {
        Parameters entity = new Parameters(size, weight, productId);

        if (repo.isExist(entity.getSize(), entity.getWeight())) {
            throw new AlreadyExistException();
        }
        repo.persist(entity);
        return entity;
    }

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public Parameters update(Parameters entity) throws NotFoundException {
        return null;
    }

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public void delete(Parameters entity) throws NotFoundException {

    }

    public List<Parameters> findAll() {
        return repo.selectAll();
    }
}
