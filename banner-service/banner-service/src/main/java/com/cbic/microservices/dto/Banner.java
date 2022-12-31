package com.cbic.microservices.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.entity.CbicContentMst;
import com.cbic.microservices.entity.CbicDocMst;
import com.cbic.microservices.entity.RequestActionDetail;
import com.cbic.microservices.entity.RequestDetails;
import com.cbic.microservices.util.DateHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Banner {

	@JsonIgnore
	private MultipartFile bannerImage;
	private String bannerName;
	private String imagePath;
	private Integer priority;
	private Date createdDate;
	private String bannerDesription;
	@JsonDeserialize(using = DateHandler.class)
	private Date startDate;
	@JsonDeserialize(using = DateHandler.class)
	private Date endDate;
	
	@JsonIgnore
	private RequestDetails requestDetails;
	
	@JsonIgnore
	private RequestActionDetail requestActionDetail;

	@JsonIgnore
	private CbicDocMst cbicDocMst;

	@JsonIgnore
	private CbicContentMst cbicContentMst;
	
	public Banner() {
		this.cbicContentMst = new CbicContentMst();
		this.cbicDocMst = new CbicDocMst();
		this.requestActionDetail = new RequestActionDetail();
		this.requestDetails = new RequestDetails();
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		if (priority != null)
			this.priority = priority;
		else
			this.priority = 1;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getBannerDesription() {
		return bannerDesription;
	}

	public void setBannerDesription(String bannerDesription) {
		this.bannerDesription = bannerDesription;
	}
	
	public MultipartFile getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(MultipartFile bannerImage) {
		this.bannerImage = bannerImage;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public RequestDetails getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}

	public RequestActionDetail getRequestActionDetail() {
		return requestActionDetail;
	}

	public void setRequestActionDetail(RequestActionDetail requestActionDetail) {
		this.requestActionDetail = requestActionDetail;
	}

	public CbicDocMst getCbicDocMst() {
		return cbicDocMst;
	}

	public void setCbicDocMst(CbicDocMst cbicDocMst) {
		this.cbicDocMst = cbicDocMst;
	}

	public CbicContentMst getCbicContentMst() {
		return cbicContentMst;
	}

	public void setCbicContentMst(CbicContentMst cbicContentMst) {
		this.cbicContentMst = cbicContentMst;
	}

	@Override
	public String toString() {
		return "Banner [bannerImage=" + bannerImage + ", bannerName=" + bannerName + ", imagePath="
				+ imagePath + ", priority=" + priority + ", createdDate=" + createdDate + ", bannerDesription="
				+ bannerDesription + ", startDate=" + startDate + ", endDate=" + endDate + ", requestDetails="
				+ requestDetails + ", requestActionDetail=" + requestActionDetail + ", cbicDocMst=" + cbicDocMst
				+ ", cbicContentMst=" + cbicContentMst + "]";
	}
	
}
