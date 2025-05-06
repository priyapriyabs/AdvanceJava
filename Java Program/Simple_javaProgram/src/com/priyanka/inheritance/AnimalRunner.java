package com.priyanka.inheritance;

public class AnimalRunner {

	public static void main(String[] args) {
	Cat	cat=new Cat();
cat.eating();
cat.sleeping();
System.out.println(cat.food);

cat.sounds();
System.out.println(cat.sound);

 Dog dog=new Dog();
 dog.eating();
 dog.sleeping();
 System.out.println(dog.noOfLegs);
 
	}

}
