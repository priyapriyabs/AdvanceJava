package com.priyanka.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class SalaryDetails {

//	@Resource(name="${saltype}")
@Autowired
	Company company;
	void details() {
		company.salary();
	}
}
