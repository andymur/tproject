package tapplication.service;

import tapplication.model.Role;

import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
public interface RoleService {

    Role findById(Long id);

    Role findByType(String type);

    List<Role> findAll();

}
