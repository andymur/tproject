package tapplication.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by alexpench on 26.03.17.
 */
public class PersistenceUtils {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistconf");

    private PersistenceUtils() {
    }

    public static EntityManager openConnection() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void closeConnection(EntityManager em) {

        try {
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
