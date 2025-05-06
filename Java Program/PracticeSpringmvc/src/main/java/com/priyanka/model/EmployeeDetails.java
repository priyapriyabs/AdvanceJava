package com.priyanka.model;

public class EmployeeDetails {

	private int emp_id;
	private String emp_name;
	private String password;
	private String email;
	private long phone;
	private String city;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [emp_id=" + emp_id + ", emp_name=" + emp_name + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", city=" + city + "]";
	}
	
	
}
