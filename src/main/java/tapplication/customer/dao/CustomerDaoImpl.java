//package tapplication.customer.dao;
//
//import org.springframework.stereotype.Component;
//import tapplication.customer.Customer;
//import tapplication.utils.PersistenceUtils;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//
///**
// * Created by alexpench on 26.03.17.
// */
//@Component
//public class CustomerDaoImpl implements CustomerDao {
//
//    public List<Customer> findAll() {
//        EntityManager em = PersistenceUtils.openConnection();
//        Query query = em.createQuery("SELECT c FROM Customer c");
//        List<Customer> customers = query.getResultList();
//        em.close();
//        return customers;
//    }
//
//        public List<Customer> findCustomer(String email) {
//            EntityManager em = PersistenceUtils.openConnection();
//            List<Customer> customers = em.createQuery(
//                    "SELECT a FROM Customer a where a.email = :email")
//                    .setParameter("email", email)
//                    .getResultList();
//            em.close();
//            return customers;
//        }
//
//    public Customer save(Customer customer) {
//        EntityManager em = PersistenceUtils.openConnection();
//        em.persist(customer);
//        em.getTransaction().commit();
//        em.close();
//        return customer;
//    }
//
//    public void update(Customer customer) {
//        EntityManager em = PersistenceUtils.openConnection();
//        em.merge(customer);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    public void delete(Customer contact) {
//
//    }
//}
