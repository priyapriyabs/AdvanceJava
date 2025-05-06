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
@Table(name = "history")
public class HistoryDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int historyId;

	    @Column(name = "user_id")
	    private Integer userId;

	    @Column(name = "complaint_id")
	    private Integer complaintId;

	    @Column(name = "department_id")
	    private Integer departmentId;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "employee-id")
	    private Integer employeeId;

	    public HistoryDTO() {
	    	log.info("acount created: "+this.getClass().getSimpleName());
	    }
}
