package com.cbic.microservices.dto;

import java.util.Date;

import com.cbic.microservices.util.DateHandler;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ValidatorView {
	
	private Integer requestId;
	private String desription;
	private Integer priority;
	@JsonDeserialize(using = DateHandler.class)
	private Date startDate;
	@JsonDeserialize(using = DateHandler.class)
	private Date endDate;
	private String file;
	private String comment;
	private String status;
	
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Snippet [requestId=" + requestId + ", desription=" + desription + ", priority=" + priority
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", file="
				+ file + ", comment=" + comment + ", status=" + status + "]";
	}
}

