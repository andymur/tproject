package tapplication.utils;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by alexpench on 26.03.17.
 */
@Component
public class PersistenceUtils {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistconf");

    private PersistenceUtils() {
    }

    public EntityManager openConnection() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public void closeConnection(EntityManager em) {

        try {
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
