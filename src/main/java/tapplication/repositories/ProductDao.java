package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Product;

import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

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

    public boolean isProductExist(String brandName, String model, String color) {

         Query query = super.getEntityManager().createQuery(
                "Select count(*) from Product p JOIN Brand b on p.brand.id = b.id where b.name = :brandName and p.model = :model and p.color = :color")
                .setParameter("brandName", brandName)
                .setParameter("model", model)
                .setParameter("color", color);
         Long count = (Long) query.getSingleResult();

         return count != 0;
    }
}
