package com.cbic.microservices.dto;

import java.util.Date;

public class Workflow {

	private String applicationName;
	private Integer requestNo;
	private String requestType;
	private String contentType;
	private String status;
	private Date initiatedOn;
	private String initiatedBy;
	private Date updatedOn;
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
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
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInitiatedOn() {
		return initiatedOn;
	}
	public void setInitiatedOn(Date initiatedOn) {
		this.initiatedOn = initiatedOn;
	}
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	@Override
	public String toString() {
		return "Workflow [applicationName=" + applicationName + ", requestNo=" + requestNo + ", requestType="
				+ requestType + ", contentType=" + contentType + ", status=" + status + ", initiatedOn=" + initiatedOn
				+ ", initiatedBy=" + initiatedBy + ", updatedOn=" + updatedOn + "]";
	}
	
}
