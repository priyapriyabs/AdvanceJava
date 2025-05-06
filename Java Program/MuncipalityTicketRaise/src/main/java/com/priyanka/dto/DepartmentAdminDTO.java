package com.priyanka.dto;

import java.time.LocalDateTime;

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
@Table(name = "department_admin")
public class DepartmentAdminDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;

	    @Column(name = "created_by")
	    private String createdBy;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "modified_by")
	    private String modifiedBy;

	    @Column(name = "modified_at")
	    private LocalDateTime modifiedAt;
	
public	DepartmentAdminDTO(){
	log.info("Account Created: "+this.getClass().getSimpleName());	
	}
}
