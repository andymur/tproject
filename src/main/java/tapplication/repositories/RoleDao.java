package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Role;

/**
 * Created by alexpench on 26.03.17.
 */
@Repository
public class RoleDao extends AbstractDao<Role, Long>{
    public RoleDao() {
        super(Role.class);
    }
}
