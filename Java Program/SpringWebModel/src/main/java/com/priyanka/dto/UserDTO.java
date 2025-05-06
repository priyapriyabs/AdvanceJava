package com.priyanka.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_info")
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@NotNull(message = "Please enter your name")
	@Size(min = 3, max = 30, message = "The name should be at least 3 to 30 characters")
	String username;
	@NotNull(message = "Please enter valid phone")
	@Min(1)
	@Max(9999999999L)
	
	Long contact_number;
	@NotBlank 
	@NotNull(message = "Please enter your Email")
	@Email(message = "Please provide valid Email")
	String email;
	@NotNull(message = "Please enter your address")
	@Size(min = 3, max = 30, message = "The address should be at least 3 to 30 characters")
	String address;
	@Column(name = "Password", nullable = false)
	String password;
}
