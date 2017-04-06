package tapplication.service;

import tapplication.exceptions.NotFoundException;

/**
 * Created by alexpench on 04.04.17.
 */
public interface CatalogService {
    Object getProductsByCategoryId(Long categoryid) throws NotFoundException;
}
