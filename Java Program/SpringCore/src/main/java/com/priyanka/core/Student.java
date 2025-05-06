package com.priyanka.core;

public class Student {

	int sid;
	String sname;
	
	private Book book;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student(int sid, String sname, Book book) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", book=" + book + "]";
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
public void	stu(){
		System.out.println("students...");
	}
}
