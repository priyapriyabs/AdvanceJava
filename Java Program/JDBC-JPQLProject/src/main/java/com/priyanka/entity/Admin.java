package com.priyanka.entity;

import java.io.File;
import java.net.URL;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableGenerator(name = "jdbc_table")
public class Admin implements Comparable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMIN_ID")
	private int admin_id;
	@Column(name = "ADMIN_NAME", length = 20,nullable = false, unique = true)
	private String admin_name;
	@Column(name = "ADMIN_EMAIL", length = 20,nullable = false,unique = true)
	private String admin_email;
	@Column(name = "ADMIN_CONTACT", length = 10,nullable = false,unique = true)
	private int admin_phone;
	@Column(name = "ADMIN_ADRESS", length = 10,nullable = false,unique = true)
	private String admin_adress;
	private File admin_file;
	@Column(name = "DATE")
	private LocalDateTime created_at;
	@Column(name="COMPANY")
	private String company;
	
	@Override
	public int compareTo(Object o) {
		Admin admin=(Admin)o;
		return admin.getAdmin_name().compareTo(this.getAdmin_name());
	}

}
