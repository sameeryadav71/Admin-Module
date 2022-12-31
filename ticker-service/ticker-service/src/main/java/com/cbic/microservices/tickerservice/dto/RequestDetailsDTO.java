package com.cbic.microservices.tickerservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

import com.sun.istack.NotNull;

@Entity
@Table(name = "request_details")
public class RequestDetailsDTO {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_no", updatable = false)
	private long requestNo;
	
	@Column(name = "request_type", updatable = false)
	private String requestType;
	
	@Column(name = "description", updatable = false)
	private String description;
	
	@Column(name = "content_type_id", updatable = false)
	private int contentTypeId;
	
	@Column(name = "content_id", updatable = false)
	private int contentId;
	
	@Column(name = "workflow_level", updatable = false)
	private int workflowLevel;
	
	@Column(name = "workflow_id", updatable = false)
	private int workflowId;
	
	@Column(name = "requested_by", updatable = false)
	private String requestedBy;
	
	@Column(name = "requested_on", updatable = false)
	private String requestedOn;
	
	@Column(name = "updated_by", updatable = false)
	private String updatedBy;
	
	@Column(name = "updated_on", updatable = false)
	private String updatedOn;
	
	@Column(name = "request_status", updatable = false)
	private String requestStatus;
	
	public long getRequestNo() {
		return requestNo;
	}
	
	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public void setRequestNo(long requestNo) {
		this.requestNo = requestNo;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getWorkflowLevel() {
		return workflowLevel;
	}
	public void setWorkflowLevel(int workflowLevel) {
		this.workflowLevel = workflowLevel;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public String getRequestedOn() {
		return requestedOn;
	}
	public void setRequestedOn(String requestedOn) {
		this.requestedOn = requestedOn;
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
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}
