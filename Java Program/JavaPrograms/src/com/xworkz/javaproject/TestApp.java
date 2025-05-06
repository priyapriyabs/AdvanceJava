package com.xworkz.javaproject;

import com.xworkz.aggregation.Address;
import com.xworkz.aggregation.CEO;
import com.xworkz.aggregation.Company;
import com.xworkz.aggregation.Employees;
import com.xworkz.aggregation.Manager;
import com.xworkz.aggregation.Salary;

public class TestApp {

	public static void main(String[] args) {
Salary	Salary=new Salary(50000, "5%");//ceo salary 
Salary	Salary2=new Salary(70000, "10%");//manager salary
Salary	Salary3=new Salary(90000, "15%");//employee salary

  Address address=new Address(2578, "Rajajinagara", "Karnataka");//ceo address
  Address address2=new Address(777, "White Field", "Chennai");//manager
  Address address3=new Address(5477, "BTM", "Pune");//employee
  
  
 CEO ceo=new CEO(30, "Jhon", "jhon@gmail.com", Salary, address);
 CEO ceo1=new CEO(10, "Arun", "Arun@gmail.com", Salary, address);
 Manager manager=new Manager(111, "Rahul", "Bangalor", Salary2, address2);
 Manager manager1=new Manager(222, "Pooja", "Mysore", Salary2, address2);
 
	Employees	employees=new Employees(123, "Priyanak", 13258741, Salary3, address3);
	Employees	employees2=new Employees(456, "Roopa", 98745111, Salary3, address3);
	
	Company hp=new Company(3321," HP","IT" , ceo, manager, employees);
	System.out.println("HP Details===");
	hp.display();
	ceo.ceoDetails();
	manager.managerDetails();
	employees.employeeDetails();
	
	Company infosys=new Company(2158," INFOSYS","IT" , ceo1, manager1, employees2);
	
	System.out.println("INFOSYS Details===");
	infosys.display();
	ceo.ceoDetails();
	manager.managerDetails();
	employees.employeeDetails();
	
	}

}
