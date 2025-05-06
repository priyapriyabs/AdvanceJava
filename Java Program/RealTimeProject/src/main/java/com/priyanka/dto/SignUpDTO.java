package com.priyanka.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@NoArgsConstructor
@AllArgsConstructor
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
	@NotNull(message = "Please enter valid phone")
    @Min(1)
    @Max(9999999999L)
	private long mobile;
	@NotNull(message = "Please Enter User Name")
	@Size(min = 3, max = 30, message = "The User name should be at least 3 to 30 characters")
	private String address;
	private String otp;
}
