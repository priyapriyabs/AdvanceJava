package com.priyanka.springjavaconfig;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

public class Account implements Company{

	int aid;
	String actype;
	
	public Account(){
		System.out.println(this.getClass().getSimpleName()+"object created");
	}

	public Account(int aid, String actype) {
		super();
		this.aid = aid;
		this.actype = actype;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", actype=" + actype + "]";
	}

	@Override
	public void salary() {
		System.out.println("account salary.....");
		
	}






}
