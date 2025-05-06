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
@Table(name = "department")
public class DepartmentDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int departmentId;

	    @Column(name = "department_name")
	    private String departmentName;

	    @Column(name = "type")
	    private String departmentType;



	    @Column(name = "area")
	    private String area;

	    public DepartmentDTO() {
	    	log.info("Acount Created:"+this.getClass().getSimpleName());
	    }


}
