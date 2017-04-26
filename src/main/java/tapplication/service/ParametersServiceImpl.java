package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tapplication.dto.ParametersDto;
import tapplication.exceptions.AlreadyExistException;
import tapplication.exceptions.NotFoundException;
import tapplication.model.Parameters;
import tapplication.model.Product;
import tapplication.repositories.ParametersDao;

/**
 * Created by alexpench on 01.04.17.
 */
@Service("parametersService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)

public class ParametersServiceImpl{
    @Autowired
    private ParametersDao repo;

    public Parameters findOne(Long id){
        Parameters parameters = repo.findOne(id);
        if (parameters == null) {
            throw new NotFoundException();
        }
        return parameters;
    }

    public Parameters create(ParametersDto parametersDto, Product product){
        if (repo.isExist(parametersDto.getSize(), parametersDto.getWeight(), product)) {
            throw new AlreadyExistException();
        }
        Parameters entity = new Parameters(parametersDto.getSize(), parametersDto.getWeight(), parametersDto.getQuantity(), product);
        repo.persist(entity);
        return entity;
    }
}
