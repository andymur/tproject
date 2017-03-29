//package tapplication.customer.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import tapplication.customer.Customer;
//import tapplication.customer.dao.CustomerDaoImpl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by alexpench on 28.03.17.
// */
//@Service("customerLoginService")
//public class CustomerLoginService implements UserDetailsService {
//    @Autowired
//    private CustomerDaoImpl customerDao;
//
//    @Transactional(readOnly=true)
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//        Customer user = customerDao.findByEmail(email);
//        setAuths.add(new SimpleGrantedAuthority(user.getRole().getName()));
//        return new User(user.getName(), user.getPassword(),true,true,true,true, new ArrayList<GrantedAuthority>(setAuths));
//    }
//}
