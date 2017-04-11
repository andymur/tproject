package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapplication.model.Role;
import tapplication.repositories.RoleDao;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
@Service("userRoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    public Role findById(Long id) {
        return dao.findOne(id);
    }

    public Role findByType(String type){
        return dao.findOne(Role.TYPE, type);
    }

    public List<Role> findAll() {
        return dao.selectAll();
    }
}
