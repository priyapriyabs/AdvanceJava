package com.priyanka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.priyanka.dto.JavaBookDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="javaBook_details")
public class JavaBookDetailsEntity {

@Id
	@GeneratedValue
	Integer id;
	String name;
	Integer price;
	Integer contactNumber;
	String email;
	String password;
}
