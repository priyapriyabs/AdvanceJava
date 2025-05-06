package com.priyanka.core;


public class Book {

	int id;
	String name;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

public void getMyBook(){
	System.out.println("my book");
}

}
