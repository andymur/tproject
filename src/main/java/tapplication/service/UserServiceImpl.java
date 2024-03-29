package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tapplication.model.User;
import tapplication.repositories.UserDaoImpl;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alexpench on 23.03.17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(Long id) {
        return dao.findOne(id);
    }

    public User findBySSO(String sso) {
        User user;
        try {
            user = dao.findOne("ssoId", sso);
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.persist(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findOne(user.getId());
        if (entity != null) {
            entity.setSsoId(user.getSsoId());
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setName(user.getName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setRole(user.getRole());
            entity.setBirthDate(user.getBirthDate());
            entity.setPhoneNumber(user.getPhoneNumber());
        }
    }


    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public List<User> findAllUsers() {
        return dao.selectAll();
    }

    public boolean isUserSSOUnique(Long id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}