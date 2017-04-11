package tapplication.repositories;


import tapplication.model.User;

import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
public interface UserDao {

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();

}