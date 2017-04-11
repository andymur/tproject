package tapplication.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import tapplication.model.User;

import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl() {
        super(User.class);
    }

    public User findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        User user = super.findOne("ssoId", sso);
        if(user!=null){
            user.getRole();
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        return super.selectAll();
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        User user = super.findOne("ssoId", sso);
        super.delete(user);
    }

}