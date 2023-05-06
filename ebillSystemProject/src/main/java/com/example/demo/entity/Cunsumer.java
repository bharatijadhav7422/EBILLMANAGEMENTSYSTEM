package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Table(name="cunsumernew")
@Entity
public class Cunsumer {
		@Column(name="cunsumer_id")
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int cunsumer_id;	
		//@NotBlank(message = "Consumer Name can not be empty")
		//@Size(max = 15,message = "Consumer Name can't be more than 15 characters")
		//@Size(min=2, message="Consumer Name must be more than 3 characters")
		@Column(name="consumer_name")
		private String consumer_name;
		//@NotBlank(message = "Address  can not be empty")
		//@Size(max = 15,message = "Address can't be more than 15 characters")
		//@Size(min=2, message="Address  must be more than 3 characters")
		@Column(name="address")
		private String address;
		//@NotNull(message = "Unit can not be null")
		@Column(name="unit")
		private int unit;
		//@NotNull(message = "BillAmt can not be null")
		@Column(name="bill_amt")
		private int bill_amt;
		//@NotNull(message = "admin_id can not be null")
		@Column(name="admin_id")
		private Integer admin_id;
		//@NotBlank(message = "Connection Type  can not be empty")
		//@Size(max = 20,message = "Connection Type can't be more than 10 characters")
		//@Size(min=2, message="Connection Type  must be more than 3 characters")
		@Column(name="connection_type")
		private String connection_type;
		@ManyToOne(targetEntity=Admin.class,fetch=FetchType.EAGER)
		@JoinColumn(name="admin_id",insertable = false,updatable = false)
	private Admin admin;
	public Cunsumer()
	{
		
	}

	public Cunsumer(int cunsumer_id, String consumer_name, String address,int unit, int bill_amt, Integer admin_id,String connection_type) 
	{
		super();
		this.cunsumer_id = cunsumer_id;
		this.consumer_name = consumer_name;
		this.address = address;
		this.unit = unit;
		this.bill_amt = bill_amt;
		this.admin_id = admin_id;
		this.connection_type = connection_type;

	}

	public int getCunsumer_id() {
		return cunsumer_id;
	}
	public void setCunsumer_id(int cunsumer_id) {
		this.cunsumer_id = cunsumer_id;
	}
	public String getConsumer_name() {
		return consumer_name;
	}
	public void setConsumer_name(String consumer_name) {
		this.consumer_name = consumer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getBill_amt() {
		return bill_amt;
	}
	public void setBill_amt(int bill_amt) {
		this.bill_amt = bill_amt;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getConnection_type() {
		return connection_type;
	}
	public void setConnection_type(String connection_type) {
		this.connection_type = connection_type;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
		
		
	}