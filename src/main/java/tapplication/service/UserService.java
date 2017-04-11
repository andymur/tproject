package tapplication.service;

import tapplication.model.User;

import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
public interface UserService {

    User findById(Long id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Long id, String sso);

}