package com.priyanka;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="student_det")
@NamedQueries({
@NamedQuery(name="selectAll" ,query="select s from Students s"),
@NamedQuery(name="login", query="select s from Students s where s.name=?1 and s.place=?2")})
public class Students {
	
	@Id
	int id;
	String name;
	String place;
	
	public Students() {
		
	}
	public Students(int id, String name, String place) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", place=" + place + "]";
	}
	

}
