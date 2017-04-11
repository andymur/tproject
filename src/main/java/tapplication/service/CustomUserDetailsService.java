package tapplication.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tapplication.model.User;
import tapplication.model.Role;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 08.04.17.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserServiceImpl userService;

    @Transactional
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        User user = userService.findBySSO(ssoId);
        logger.info("User : {}", user);
        if (user == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Role role = user.getRole();
        logger.info("UserProfile : {}", role);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
        logger.info("authorities : {}", authorities);
        return authorities;
    }
}