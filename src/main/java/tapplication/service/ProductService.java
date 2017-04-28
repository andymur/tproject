package tapplication.service;

import tapplication.dto.ProductAndAmount;
import tapplication.dto.ProductDto;
import tapplication.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by alexpench on 22.04.17.
 */
public interface ProductService {
    List<Product> findAll();

    void update(ProductDto productDto);

    ProductDto create(final ProductDto newProduct);

    List<Product> findAllByCategory(Long categoryId);

    List<ProductDto> getProductsByCategoryId(Long categoryId);

    List<ProductDto> getAllProductsDtoList();

    List<ProductDto> findAllByParams(Long categoryId, String brand, String color, String size);

    Product findOne(Long productId);

    ProductDto findOneDto(Long productId);

    Product moveToOrder(Long productId, Long quantity, String size);

    void moveFromExpiredOrder(Product product, Long quantity, String size);

    List<ProductDto> getProducts(List<ProductAndAmount> productAndAmounts);

    Set<String> getColors(List<ProductDto> products);

    Set<String> getBrands(List<ProductDto> products);

    Set<String> getSizes(List<ProductDto> products);
}