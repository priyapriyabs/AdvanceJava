package com.priyanka.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sign_up")
public class SignUpDTO {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Please Enter User Name")
	@Size(min = 3, max = 30, message = "The User name should be at least 3 to 30 characters")
	private String username;
	@Email(message = "Please provide valid Email")
	private String email;
	private String password;
	@NotNull(message = "Please Enter mobile number")
	@Min(10)
	@Max(10)
	private long mobile;
	@NotNull(message = "Please Enter address")
	@Size(min = 3, max = 30, message = "The User name should be at least 3 to 30 characters")
	private String address;
	private String otp;
	@Column(name = "failed_attempt")
	private int failedAttempts;

	@Transient
	private boolean accountLocked;
	
	
}
