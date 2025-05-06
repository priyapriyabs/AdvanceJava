package com.priyanka.superMarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "super_marker_info")
public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "market_name", insertable=false, updatable=false)
	private String marketName;
	private String location;
	@Column(name = "customer_care", insertable=false, updatable=false)
	private String customerCare;
	private String email;
	@Column(name = "market_name", insertable=false, updatable=false)
	private String managerName;
	@Column(name = "manager_id", insertable=false, updatable=false)
	private int managerId;
}
