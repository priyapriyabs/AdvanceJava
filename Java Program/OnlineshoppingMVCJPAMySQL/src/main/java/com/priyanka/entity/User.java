package com.priyanka.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_reg")
public class User {

	@Id
	private int id;
	private String name;
	private String password;
	private String email;
	private long phoneno;
	
	
}
