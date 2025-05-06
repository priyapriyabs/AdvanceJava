package com.priyanka.entairconcpt;

import java.lang.annotation.Native;

import java.time.LocalDateTime;

public class AllPrograms implements Owner{

	
	private int id;
	private String name;
	private String place;
	@Native
	private long phone;
	private LocalDateTime dateAndTime;
	private static double salary;
	private final float IFSC_CODE=121;
	private boolean isActive;
	private MyPlace myPlace;
	
	public AllPrograms() {
		
	}

	public AllPrograms(int id, String name, String place, long phone, boolean isActive,
			MyPlace myPlace) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.phone = phone;
		this.isActive = isActive;
		this.myPlace = myPlace;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public static double getSalary() {
		return salary;
	}

	public static void setSalary(double salary) {
		AllPrograms.salary = salary;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public float getIFSC_CODE() {
		return IFSC_CODE;
	}

	
	
	public MyPlace getMyPlace() {
		return myPlace;
	}

	public void setMyPlace(MyPlace myPlace) {
		this.myPlace = myPlace;
	}

	@Override
	public String toString() {
		return "AllPrograms [id=" + id + ", name=" + name + ", place=" + place + ", phone=" + phone + ", dateAndTime="
				+ dateAndTime + ", IFSC_CODE=" + IFSC_CODE + ", isActive=" + isActive + ", myPlace=" + myPlace + "]";
	}

	@Override
	public void rent(MyPlace mp) {
		mp.mymethod();
		System.out.println("rent 5000");
		
	}

	@Override
	public void current() {
		System.out.println("current bill 500");
		
	}

}
