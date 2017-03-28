package tapplication.customer.role.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapplication.customer.role.Role;
import tapplication.utils.PersistenceUtils;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private PersistenceUtils pUtil;

    public Role findById(Long id) {
        Role role = pUtil.openConnection().find(Role.class, id);
        return role;
    }
}
