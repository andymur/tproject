package tapplication.repositories;

import org.springframework.stereotype.Repository;
import tapplication.dto.ProductDto;
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

    public static final String NAME = "name";

    public ProductDao() {
        super(Product.class);
    }

    @Override
    public void persist(Product product) {

        super.persist(product);
    }

    public boolean isProductExistWithSameSize(ProductDto productDto) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.distinct(true).from(Product.class);
        Join<Product, Parameters> parameters = product.join(Product.PARAMETERS);
        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.equal(product.get(Product.MODEL), productDto.getModel())));
        predList.add(builder.and(builder.equal(parameters.get(Parameters.SIZE), productDto.getParameters().get(0).getSize())));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);
        return super.find(query).size() > 0;
    }

    public boolean isNewSizeForExistingProduct(ProductDto product) {
        Query query = super.getEntityManager().createQuery(
                "Select count(*) from Product p " +
                        "where p.model = :model ")
                .setParameter("model", product.getModel());
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
        Root<Product> product = query.distinct(true).from(Product.class);
        Join<Product, Parameters> parameters = product.join(Product.PARAMETERS);
        Join<Product, Brand> brands = product.join(Product.BRAND);
        List<Predicate> predList = new LinkedList<>();
        if (!categoryId.equals("undefined")) {
            predList.add(builder.and(builder.equal(product.get(Product.PRODUCT_CATEGORY), categoryId)));
        }
        if (brand != null && !brand.equals("undefined")) {
            predList.add(builder.and(builder.equal(brands.get(NAME), brand)));
        }
        if (color != null && !color.equals("undefined")) {
            predList.add(builder.and(builder.equal(product.get(Product.COLOR), color)));
        }
        if (size != null && !size.equals("undefined")) {
            predList.add(builder.and(builder.equal(parameters.get(Parameters.SIZE), size)));
        }
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        return super.find(query);
    }
}
