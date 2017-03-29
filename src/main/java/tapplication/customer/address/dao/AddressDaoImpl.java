package tapplication.customer.address.dao;

import org.springframework.stereotype.Component;
import tapplication.customer.address.Address;
import tapplication.utils.PersistenceUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class AddressDaoImpl implements AddressDao {

    public Address save(Address address) {
        EntityManager em = PersistenceUtils.openConnection();
        em.persist(address);
        em.getTransaction().commit();
        em.close();
        return address;
    }

    public List<Address> getAllByCustomerId(Long id) {
        EntityManager em = PersistenceUtils.openConnection();
        Query query = em.createQuery("SELECT a FROM Address a where a.customer.id = :id");
        List<Address> addresses = query.getResultList();
        em.close();
        return addresses;
    }

    public void update(Address address) {
        EntityManager em = PersistenceUtils.openConnection();
        em.merge(address);
        em.getTransaction().commit();
        em.close();
    }
}
