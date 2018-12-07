package org.hung.dao;

import org.hung.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author vdnh
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
