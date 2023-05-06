package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="adminnew")

public class Admin {
	@Column(name="admin_id")
	@Id
	private int admin_id;
	@NotBlank(message = "Admin Name can not be empty")
	@Size(max = 15,message = "Admin Name can't be more than 15 characters")
	@Size(min=2, message="Admin Name must be more than 3 characters")
	@Column(name="AdminName")
	private String AdminName;
	@NotBlank(message = "Division Name can not be empty")
	@Size(max = 15,message = "Division Name can't be more than 15 characters")
	@Size(min=2, message="Division Name must be more than 3 characters")
	@Column(name="Division")
	private String Division;
	@OneToMany(mappedBy="admin")
	private Set<Cunsumer>Cunsumer;
	public Admin()
	{
		
	}
	public Admin(int admin_id, String adminName, String division) {
		super();
		this.admin_id = admin_id;
		this.AdminName = adminName;
		this.Division = division;
		
	}
	public int getadmin_id() {
		return admin_id;
	}
	public void setadmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		this.AdminName = adminName;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		this.Division = division;
	}
}