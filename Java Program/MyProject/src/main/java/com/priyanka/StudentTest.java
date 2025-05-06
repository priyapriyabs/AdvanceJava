package com.priyanka;



import java.util.Iterator;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	EntityManagerFactory	emf=Persistence.createEntityManagerFactory("studentinfo");
EntityManager	em=emf.createEntityManager();
//	em.getTransaction().begin();
//Students	s1=new Students(1, "priya", "bng");
//Students	s2=new Students(2, "riya", "chn");
//Students	s3=new Students(3, "Rahul", "hyd");
//Students	s4=new Students(4, "arun", "pune");
//em.persist(s1);
//em.persist(s2);
//em.persist(s3);
//em.persist(s4);
//	em.getTransaction().commit();
//String q1="select s from Students s";
//	String q1="select s from Students s where name='priya'";
String q1="update Students s set s.name='ruchi' where s.id=1";
em.getTransaction().begin();
	Query query=em.createQuery(q1);
	
//List<Students>	stu=query.getResultList();
//Students	stu=(Students)query.getSingleResult();
	
int	stu=query.executeUpdate();
em.getTransaction().commit();
System.out.println(stu);
//for(Students s:stu) {
//	System.out.println(s.getName());
//}
	
	}

}
