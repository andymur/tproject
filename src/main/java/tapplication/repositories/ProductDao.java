package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Product;
import tapplication.repositories.AbstractDao;

import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 * Created by alexpench on 29.03.17.
 */
@Repository("productDao")
public class ProductDao extends AbstractDao<Product, Id>{

    public ProductDao() {
        super(Product.class);
    }

    @Override
    public void persist(Product product){

        super.persist(product);
    }

    public Product getProductIfExist(String brandName, String model, String color) throws NoResultException, NonUniqueResultException {

         Product product =(Product) super.getEntityManager().createQuery(
                "Select p from Product p JOIN Brand b on p.brand.id = b.id where b.name = :brandName and p.model = :model and p.color = :color")
                .setParameter("brandName", brandName)
                .setParameter("model", model)
                .setParameter("color", color).getSingleResult();
         return product;
    }

    public boolean isProductExist(String brandName, String model, String color) {

        return super.getEntityManager().createQuery(
                "Select p from Product p JOIN Brand b on p.brand.id = b.id where b.name = :brandName and p.model = :model and p.color = :color")
                .setParameter("brandName", brandName)
                .setParameter("model", model)
                .setParameter("color", color).getFirstResult() > -1;
    }


    //        public List<Customer> findCustomer(String email) {
//            EntityManager em = PersistenceUtils.openConnection();
//            List<Customer> customers = em.createQuery(
//                    "SELECT a FROM Customer a where a.email = :email")
//                    .setParameter("email", email)
//                    .getResultList();
//            em.close();
//            return customers;
//        }
}
