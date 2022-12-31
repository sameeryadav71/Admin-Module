package com.cbic.microservices.tickerservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name = "request_action_detail")
public class RequestActionDetailDTO {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "action_id", updatable = false)
	private int actionId;
	
	@Column(name = "request_id", updatable = false)
	@NotNull
	private int requestId;
	
	@Column(name = "role_id", updatable = false)
	private String roleId;
	
	@Column(name = "wf_level", updatable = false)
	private int wfLevel;
	
	@Column(name = "status", updatable = false)
	private String status;
	
	@Column(name = "comment", updatable = false)
	private String comment;
	
	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@Column(name = "created_on", updatable = false)
	private String createdOn;
	
	@Column(name = "updated_by", updatable = false)
	private String updatedBy;
	
	@Column(name = "updated_on", updatable = false)
	private String updatedOn;
	@Column(name = "closed_on", updatable = false)
	private String closedOn;
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public int getWfLevel() {
		return wfLevel;
	}
	public void setWfLevel(int wfLevel) {
		this.wfLevel = wfLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}
	
	
}
