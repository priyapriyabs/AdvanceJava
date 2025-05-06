package com.priyanka;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("student");
       EntityManager em=emf.createEntityManager();
    em.getTransaction().begin();
Student s=new Student();
s.setId(123);
s.setName("priya");
s.setPlace("shimoga");
em.persist(s);
    em.getTransaction().commit();
    }
}
