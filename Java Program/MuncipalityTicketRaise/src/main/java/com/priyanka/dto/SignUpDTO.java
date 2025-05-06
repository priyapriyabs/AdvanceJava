package com.priyanka.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@AllArgsConstructor
@Slf4j
@Table(name = "signup")
public class SignUpDTO {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @NotNull(message = "Please Enter First Name")
	    @Size(min = 3, max = 30, message = "The First name should be at least 3 to 30 characters")
	    @Column(name = "first_name")
	    private String firstName;
	    @NotNull(message = "Please Enter Last Name")
	    @Size(min = 3, max = 30, message = "The Last name should be at least 3 to 30 characters")
	    @Column(name = "last_name")
	    private String lastName;
	    @Email(message = "Please provide valid Email")
	    private String email;

	    @NotNull(message = "Please enter valid phone")
	    @Min(1)
	    @Max(9999999999L)
	    private Long phone;

	    @Transient
	    private String confirm;


	    @Column(name = "created_by")
	    private String createdBy;
	    @Column(name = "created_at")
	    private LocalDateTime createdAt;
	    @Column(name = "modified_by")
	    private String modifiedBy;
	    @Column(name = "modified_at")
	    private LocalDateTime modifiedAt;


	    @Column(name = "password")
	    private String password;


	    @Column(name = "user_password")
	    private String newPassword;

	    @Column(name = "count")
	    private Integer count = 0;

	    @Column(name = "failed_attempt")
	    private int failedAttempts=0;

	    @Transient
	    private boolean accountLocked=false;

	    @Column(name = "profile_image")
	    private String profileImage;

	    public SignUpDTO() {
	    	log.info("Acount Created: "+this.getClass().getSimpleName());
	    }

}
