package com.priyanka.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class PasswordResetDTO {

	 @NotEmpty(message = "Please enter valid password")
	   @Size(min = 16,message = "Please enter 16 characters")
	    private String password;

	   @NotEmpty(message = "Please enter new password")
	   @Size(min = 5,message = "Please enter min 5 characters of New Password")
	    private String newPassword;

	    @NotEmpty(message = "Please enter email")

	    private String email;

	    @NotEmpty(message = "Please enter confirm password")
	    @Size(min = 5,message = "Please enter min 5 characters of Confirm Password")
	    private String confirmPassword;
	    
	    public PasswordResetDTO() {
	    	log.info("acount created: "+this.getClass().getSimpleName());
	    }
}
