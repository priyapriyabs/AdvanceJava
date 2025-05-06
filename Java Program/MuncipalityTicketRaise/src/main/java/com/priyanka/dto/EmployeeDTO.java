package com.priyanka.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@AllArgsConstructor
@Slf4j
@Table(name = "department_employee")
public class EmployeeDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "department_id")
	    private Integer departmentId;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "designation")
	    private String designation;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "phone")
	    private Long phone;

	    @Column(name = "password")
	    private String password;

	    public EmployeeDTO() {
	    	log.info("Acount Created: "+this.getClass().getSimpleName());
	    }

}
