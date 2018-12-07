package org.hung.dao;

//import java.awt.print.Pageable;
import java.util.List;
import org.hung.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author vdnh
 */
@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long>{
    @Query("select c from Contact c where c.nom like :x")
    public Page<Contact> chercher(@Param("x") String mc, Pageable pageable);
    //public Page<Contact> chercher(@Param("x") String mc, PageRequest pageable);
}
