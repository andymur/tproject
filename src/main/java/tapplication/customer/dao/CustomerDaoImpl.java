package tapplication.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapplication.customer.Customer;
import tapplication.utils.PersistenceUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private PersistenceUtils pUtil;

    public List<Customer> findAll() {
        EntityManager em = pUtil.openConnection();
        Query query = em.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = query.getResultList();
        em.close();
        return customers;
    }

    public Customer findByEmail(String email) {
        EntityManager em = pUtil.openConnection();
        Query query = em.createQuery("SELECT a FROM Address a where a.customer.email = :email");
        Customer customer = (Customer) query.getSingleResult();
        em.close();
        return customer;
    }

    public Customer save(Customer customer) {
        EntityManager em = pUtil.openConnection();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
        return customer;
    }

    public void update(Customer customer) {
        EntityManager em = pUtil.openConnection();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Customer contact) {

    }
}
