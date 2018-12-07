package org.hung.web;

import org.springframework.data.domain.Pageable;
import java.util.List;
//import javax.ws.rs.QueryParam;
import org.hung.dao.ContactRepository;
import org.hung.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vdnh
 */
@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;
    
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id){
        return contactRepository.findById(id).get();
    }
    
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }
    
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Long id){
        contactRepository.deleteById(id);
        return true;
    }
    
    @RequestMapping(value = "/contacts", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(name = "id") Long id){
        contactRepository.deleteById(id);
        return true;
    }
    
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact c){
        c.setId(id);
        Contact con = contactRepository.getOne(id);
//        if (c.getEmail() == null) c.setEmail(con.getEmail());
//        if (c.getDateNaissance() == null) c.setDateNaissance(con.getDateNaissance());
//        if (c.getNom()== null) c.setNom(con.getNom());
//        if (c.getPrenom()== null) c.setPrenom(con.getPrenom());
//        if (c.getTel()== 0) c.setTel(con.getTel());
//        if (c.getPhoto()== null) c.setPhoto(con.getPhoto());
//        
        return contactRepository.save(c);
    }    
    
    @RequestMapping(value = "/chercherContacts", method = RequestMethod.GET)
    public Page<Contact> chercher(
            @RequestParam(name = "mc", defaultValue = "") String mc, 
            @RequestParam(name = "page", defaultValue = "0")int page, 
            @RequestParam(name = "size", defaultValue = "5")int size){
        //Pageable pb = (Pageable) PageRequest.of(page,size);
        return contactRepository.chercher("%"+mc+"%", PageRequest.of(page, size));
    }    
}
