package tapplication.customer.role.dao;

import org.springframework.stereotype.Repository;
import tapplication.customer.role.Role;
import tapplication.dao.AbstractDao;

import javax.persistence.Id;

/**
 * Created by alexpench on 26.03.17.
 */
@Repository
public class RoleDao extends AbstractDao<Role, Id>{
    public RoleDao() {
        super(Role.class);
    }
}
