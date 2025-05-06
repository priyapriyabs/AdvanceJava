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
@Table(name = "complaint")
public class ComplaintsDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "type")
	    private String type;

	    @Column(name = "area")
	    private String area;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "country")
	    private String country;

	    @Column(name = "state")
	    private String state;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "user_id")
	    private int userId;

	    @Column(name = "created_by")
	    private String createdBy;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "modified_by")
	    private String modifiedBy;

	    @Column(name = "modified_at")
	    private LocalDateTime modifiedAt;

	    @Column(name = "status")
	    private String status;


	    @Column(name="department_id")
	    private Integer departmentId;

	    @Column(name = "employee_id")
	    private Integer employeeId;

	    @Column(name = "comments")
	    private String comments;

	    @Column(name = "otp")
	    private String otp;

public ComplaintsDTO() {
	log.info("Account Created: "+this.getClass().getSimpleName());
}

}
