package com.priyanka;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory	emf=Persistence.createEntityManagerFactory("studentinfo");
    	EntityManager	em=emf.createEntityManager();
    	Query query=em.createNamedQuery("selectAll");
    	Query query2=em.createNamedQuery("login").setParameter(1, "ruchI").setParameter(2, "bng");
    	
    	try {
    		Students s=(Students)query2.getSingleResult();
    		if(s!=null) {
        		System.out.println("valide name"+s.getName()+s.getPlace());
    			
        	}
        		
		}
    	
    	 catch (Exception e) {
 			System.out.println("invalide name");
 		}
    	
    }
}
