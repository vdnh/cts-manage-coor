package org.hung;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.hung.dao.ContactRepository;
import org.hung.dao.ProductRepository;
import org.hung.entities.Contact;
import org.hung.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication  implements CommandLineRunner{
    
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ProductRepository productRepository;
    
    public static void main(String[] args) {
            SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        productRepository.save(new Product(null, "Gato",Float.valueOf(5)));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact("hung","vodinh", df.parse("26/06/1975"), "vdnh@yahoo.com", 7283785, "testphoto.jpg"));
        contactRepository.save(new Contact("hung01","vodinh", df.parse("26/06/1976"), "vdnh1@yahoo.com", 8283785, "testphoto01.jpg"));
        contactRepository.save(new Contact("hung02","vodinh", df.parse("26/06/1977"), "vdnh2@yahoo.com", 9283785, "testphoto02.jpg"));
        contactRepository.findAll().forEach(c ->{
            System.out.println(c.getNom());
            System.out.println(c.getPrenom());
            System.out.println(c.getDateNaissance());
            System.out.println(c.getEmail());
            System.out.println(c.getTel());
            System.out.println(c.getPhoto());
        });//*/
        System.out.println("");
    }
}
