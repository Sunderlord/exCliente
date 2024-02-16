package it.degroup.ex1.dao;

import it.degroup.ex1.models.Book;
import java.util.ArrayList;


import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("corso_jpa");
    private EntityManager em=emf.createEntityManager();

    public List<Book> findAllBook() {
        Query q = em.createNativeQuery("select * from Book",Book.class);
        var b=q.getResultList();
        List<Book> list=q.getResultList();
        return list;
    }

    public Book addBook(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        return book;
    }
    public Book findByName(String name) {
        Query q=em.createNativeQuery("select * from Book where isbn= :isbn",Book.class);
        q.setParameter("isbn",name);
        Book result;
        try{
            result=(Book) q.getSingleResult();
        }catch(NoResultException e){
            e.printStackTrace();
            result=null;
        }
        return result;
    }
}
