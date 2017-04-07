package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.model.Brand;
import tapplication.model.Parameters;
import tapplication.model.Product;

import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexpench on 29.03.17.
 */
@Repository("productDao")
public class ProductDao extends AbstractDao<Product, Long> {

    public ProductDao() {
        super(Product.class);
    }

    @Override
    public void persist(Product product) {

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


    public List<Product> findByCategoryId(Long categoryId) {
        return super.getEntityManager().createQuery(
                "Select p from Product p where p.category.id = :categoryId")
                .setParameter("categoryId", categoryId).getResultList();
    }

    public List<Product> findByParams(Long categoryId, String brand, String color, String size) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        Join<Product, Parameters> parameters = product.join(Product.PARAMETERS);
        Join<Product, Brand> brands = product.join(Product.BRAND);
        List<Predicate> predList = new LinkedList<>();
        if (categoryId != null) {
            predList.add(builder.and(builder.equal(product.get(Product.PRODUCT_CATEGORY), categoryId)));
        }
        if (brand != null) {
            predList.add(builder.and(builder.equal(brands.get("name"), brand)));
        }
        if (color != null) {
            predList.add(builder.and(builder.equal(product.get(Product.COLOR), color)));
        }
        if (size != null) {
            predList.add(builder.and(builder.equal(parameters.get(Parameters.SIZE), size)));
        }
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        return super.find(query);
    }
}
