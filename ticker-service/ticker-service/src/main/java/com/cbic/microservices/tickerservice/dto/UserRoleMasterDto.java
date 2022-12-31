package com.cbic.microservices.tickerservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user_role_mst")
public class UserRoleMasterDto {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false)
	private int userId;
	
	@Column(name = "ssoid", updatable = false)
	private int ssoid;
	
	@Column(name = "email", updatable = false)
	private String email;
	
	@Column(name = "phone_no", updatable = false)
	private String phoneNo;
	
	@Column(name = "role_id", updatable = false)
	private int roleId;
	
	@Column(name = "created_by", updatable = false)
	private int createdBy;
	
	@Column(name = "created_on", updatable = false)
	private String createdOn;
	
	@Column(name = "isactive", updatable = false)
	private int isactive;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSsoid() {
		return ssoid;
	}

	public void setSsoid(int ssoid) {
		this.ssoid = ssoid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
}
