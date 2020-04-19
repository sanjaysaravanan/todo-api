package com.example.demo.todo;

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
@ApiModel(description = "Details about the ToDo")
@Table(name = "todo")
public class ToDo {
	@ApiModelProperty(notes = "Unique ID for the ToDo")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ApiModelProperty(notes = "Unique username for the ToDo")
	@Column(name = "username")
	private String username;
	
	@ApiModelProperty(notes = "Description for the ToDo")
	@Column(name = "description")
	private String description;
	
	@ApiModelProperty(notes = "Target date for the ToDo")
	@Column(name = "target_date")
	private Date targetDate;
	
	@ApiModelProperty(notes = "Is Todo completed... ?")
	@Column(name = "is_done")
	private boolean isDone;

	public ToDo() {
		
	}
	
	public ToDo(String username, String description, Date targetDate, boolean isDone) {
		super();
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
