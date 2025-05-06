package com.xworkz.javaproject;

import com.xworkz.methodOveloading.Docter;
import com.xworkz.methodOveloading.Lawyer;
import com.xworkz.methodOveloading.Person;
import com.xworkz.methodOveloading.Teacher;

public class TestOverridingPerson {

	public static void main(String[] args) {

		Person person = new Teacher();
		person.workInfo();
		person.activity();
		System.out.println("========");

		Person person1 = new Docter();
		person1.workInfo();
		person1.activity();
		System.out.println("========");

		Person person2 = new Lawyer();
		person2.workInfo();
		person2.activity();
	}

}
