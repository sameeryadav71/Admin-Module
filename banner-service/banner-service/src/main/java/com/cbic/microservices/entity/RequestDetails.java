package com.cbic.microservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_details")
public class RequestDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestNo;
	private String requestType;
	private String description;
	private Integer contentTypeId;
	private Integer contentId;
	private Integer workflowLevel;
	private String requestedBy;
	private Date requestedOn;
	private String updatedBy;
	private Date updatedOn;
	private String requestStatus;
	
	public Integer getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(Integer requestNo) {
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
	public Integer getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getWorkflowLevel() {
		return workflowLevel;
	}
	public void setWorkflowLevel(Integer workflowLevel) {
		this.workflowLevel = workflowLevel;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Date getRequestedOn() {
		return requestedOn;
	}
	public void setRequestedOn(Date requestedOn) {
		this.requestedOn = requestedOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Override
	public String toString() {
		return "RequestDetails [requestNo=" + requestNo + ", requestType=" + requestType + ", description="
				+ description + ", contentTypeId=" + contentTypeId + ", contentId=" + contentId + ", workflowLevel="
				+ workflowLevel + ", requestedBy=" + requestedBy + ", requestedOn=" + requestedOn + ", updatedBy="
				+ updatedBy + ", updatedOn=" + updatedOn + ", requestStatus=" + requestStatus + "]";
	}	
}
