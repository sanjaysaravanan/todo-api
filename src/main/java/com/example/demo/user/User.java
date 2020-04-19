package com.example.demo.user;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about an user")
@Table(name = "User")
public class User {
	
	@ApiModelProperty(notes = "Unique ID for the User")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ApiModelProperty(notes = "Name of the User")
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(notes = "Date of Birth of User")
	@Column(name = "date")
	private Date dob;
	
	@ApiModelProperty(notes = "Mobile Number of the User")
	@Column(name = "mobile")
	private BigInteger phoneNumber;
	
	@ApiModelProperty(notes = "Email of the User")
	@Column(name = "mail")
	private String email;
	
	public User() {
		
	}
	
	public User(String name, Date dob, BigInteger phoneNumber, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [name=" + name
				+ ", dob=" + dob 
				+ ", Mobile=" + phoneNumber
				+ ", Email=" + email
				+  "]";
	}

}
