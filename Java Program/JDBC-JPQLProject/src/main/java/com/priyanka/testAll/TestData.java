package com.priyanka.testAll;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.priyanka.entity.Admin;
import com.priyanka.queries.SQLQueries;
import com.priyanka.service.AdminServiceImlp;

public class TestData {

	public static void main(String[] args) {
		Admin admin = new Admin();
//		admin.setAdmin_name("Aishwarya B");
//		admin.setAdmin_email("aishu@gmail.com");
//		admin.setAdmin_adress("Hyd");
//		admin.setAdmin_phone(374864125);
//	File	filePath=new File(SQLQueries.FILE_LOCATION+admin.getAdmin_file());
//	filePath.canWrite();
//	admin.setAdmin_file(filePath);		
//		admin.setCreated_at(LocalDateTime.now());
//		admin.setCompany("wipro");
		
		AdminServiceImlp adminServiceImlp = new AdminServiceImlp();
//		adminServiceImlp.saveAdmin(admin);
//	   adminServiceImlp.deleteRow(admin);
//	   adminServiceImlp.updateRow(admin);
//		adminServiceImlp.addConstraint(admin);//ddl not work here
		
List<Admin>	a=adminServiceImlp.findAll(admin);
//	System.out.println(a);
//	adminServiceImlp.findNorm(admin);    
//	System.out.println(admins);
   ListIterator<Admin> spl=a.listIterator();

List<Admin> admins=new ArrayList<Admin>();


//Map m=new HashMap<>();
//m.put(admins, a);
//System.out.println(m);

	try {
//		  Set<Admin> admins=new HashSet<Admin>();
//		  admins.addAll(a);
//		  List<Admin> ls=admins.stream().sorted().collect(Collectors.toList());
//		List<Admin> ls=admins.stream().filter(b->admin.getAdmin_file().equals(b.getAdmin_file())).collect(Collectors.toList());
//		System.out.println(ls);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
//		System.out.println(admins);
//ListIterator<Admin>	spl=admins.listIterator();

//while(spl.hasNext()) {
//	System.out.println(spl.next());
//	
//}
//while(spl.hasPrevious()) {
//	System.out.println(spl.previous());
//	
//}
	}

}
