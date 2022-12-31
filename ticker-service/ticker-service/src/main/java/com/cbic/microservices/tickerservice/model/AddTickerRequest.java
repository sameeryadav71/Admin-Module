package com.cbic.microservices.tickerservice.model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTickerRequest {
	private String userSSOId;
	private String appName;
	private String requestType;
	private String description;
	private int priority;
	private String docbase;
	private Date startDate;
	private Date endDate;
	private ArrayList<TickerDetailBean> detailBean;
	private String contentType;
	private int contentTypeId;
	private int workflowId;
	private int workflowLevel;
	public int getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}
	public int getWorkflowLevel() {
		return workflowLevel;
	}
	public void setWorkflowLevel(int workflowLevel) {
		this.workflowLevel = workflowLevel;
	}
	public String getUserSSOId() {
		return userSSOId;
	}
	public void setUserSSOId(String userSSOId) {
		this.userSSOId = userSSOId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getDocbase() {
		return docbase;
	}
	public void setDocbase(String docbase) {
		this.docbase = docbase;
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
	public ArrayList<TickerDetailBean> getDetailBean() {
		return detailBean;
	}
	public void setDetailBean(ArrayList<TickerDetailBean> detailBean) {
		this.detailBean = detailBean;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public AddTickerRequest(String userSSOId, String appName, String requestType, String description, int priority,
			String docBase, Date startDate, Date endDate, ArrayList<TickerDetailBean> detailBean, String contentType,
			int contentTypeId) {
		super();
		this.userSSOId = userSSOId;
		this.appName = appName;
		this.requestType = requestType;
		this.description = description;
		this.priority = priority;
		this.docbase = docbase;
		this.startDate = startDate;
		this.endDate = endDate;
		this.detailBean = detailBean;
		this.contentType = contentType;
		this.contentTypeId = contentTypeId;
	}
	public AddTickerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
