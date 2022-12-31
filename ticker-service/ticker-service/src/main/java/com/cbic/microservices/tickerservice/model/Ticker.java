package com.cbic.microservices.tickerservice.model;

import java.time.ZonedDateTime;

public class Ticker {
    private Long id;
    private String isActive;
    private Long orderId;
    private ZonedDateTime createdDt;
    private ZonedDateTime updatedDt;
    private Long createdBy;
    private Long updateBy;
    private Long versionNo;
    private String isPublished;
    private ZonedDateTime publishDt;
    private String isArchived;
    private ZonedDateTime archiveDt;
    private Long parentId;
    private Long taxId;
    private Long locationId;
    private String titleEn;
    private String titleHi;
    private String infoEn;
    private String infoHi;
    private String refNumber;
    private String path;
    private ZonedDateTime contentDt;
    private ZonedDateTime refDt1;
    private ZonedDateTime refDt2;
    private ZonedDateTime expiryDt;
    private Long year;
    private Long contentTypeId;
    
	public Ticker(Long id, String isActive, Long orderId, ZonedDateTime createdDt, ZonedDateTime updatedDt,
			Long createdBy, Long updateBy, Long versionNo, String isPublished, ZonedDateTime publishDt,
			String isArchived, ZonedDateTime archiveDt, Long parentId, Long taxId, Long locationId, String titleEn,
			String titleHi, String infoEn, String infoHi, String refNumber, String path, ZonedDateTime contentDt,
			ZonedDateTime refDt1, ZonedDateTime refDt2, ZonedDateTime expiryDt, Long year, Long contentTypeId) {
		super();
		this.id = id;
		this.isActive = isActive;
		this.orderId = orderId;
		this.createdDt = createdDt;
		this.updatedDt = updatedDt;
		this.createdBy = createdBy;
		this.updateBy = updateBy;
		this.versionNo = versionNo;
		this.isPublished = isPublished;
		this.publishDt = publishDt;
		this.isArchived = isArchived;
		this.archiveDt = archiveDt;
		this.parentId = parentId;
		this.taxId = taxId;
		this.locationId = locationId;
		this.titleEn = titleEn;
		this.titleHi = titleHi;
		this.infoEn = infoEn;
		this.infoHi = infoHi;
		this.refNumber = refNumber;
		this.path = path;
		this.contentDt = contentDt;
		this.refDt1 = refDt1;
		this.refDt2 = refDt2;
		this.expiryDt = expiryDt;
		this.year = year;
		this.contentTypeId = contentTypeId;
	}
	public Ticker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Ticker [id=" + id + ", isActive=" + isActive + ", orderId=" + orderId + ", createdDt=" + createdDt
				+ ", updatedDt=" + updatedDt + ", createdBy=" + createdBy + ", updateBy=" + updateBy + ", versionNo="
				+ versionNo + ", isPublished=" + isPublished + ", publishDt=" + publishDt + ", isArchived=" + isArchived
				+ ", archiveDt=" + archiveDt + ", parentId=" + parentId + ", taxId=" + taxId + ", locationId="
				+ locationId + ", titleEn=" + titleEn + ", titleHi=" + titleHi + ", infoEn=" + infoEn + ", infoHi="
				+ infoHi + ", refNumber=" + refNumber + ", path=" + path + ", contentDt=" + contentDt + ", refDt1="
				+ refDt1 + ", refDt2=" + refDt2 + ", expiryDt=" + expiryDt + ", year=" + year + ", contentTypeId="
				+ contentTypeId + "]";
	}
	
	
	
	public Long getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Long contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public ZonedDateTime getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(ZonedDateTime createdDt) {
		this.createdDt = createdDt;
	}
	public ZonedDateTime getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(ZonedDateTime updatedDt) {
		this.updatedDt = updatedDt;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	public Long getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}
	public String getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}
	public ZonedDateTime getPublishDt() {
		return publishDt;
	}
	public void setPublishDt(ZonedDateTime publishDt) {
		this.publishDt = publishDt;
	}
	public String getIsArchived() {
		return isArchived;
	}
	public void setIsArchived(String isArchived) {
		this.isArchived = isArchived;
	}
	public ZonedDateTime getArchiveDt() {
		return archiveDt;
	}
	public void setArchiveDt(ZonedDateTime archiveDt) {
		this.archiveDt = archiveDt;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getTaxId() {
		return taxId;
	}
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	public String getTitleHi() {
		return titleHi;
	}
	public void setTitleHi(String titleHi) {
		this.titleHi = titleHi;
	}
	public String getInfoEn() {
		return infoEn;
	}
	public void setInfoEn(String infoEn) {
		this.infoEn = infoEn;
	}
	public String getInfoHi() {
		return infoHi;
	}
	public void setInfoHi(String infoHi) {
		this.infoHi = infoHi;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ZonedDateTime getContentDt() {
		return contentDt;
	}
	public void setContentDt(ZonedDateTime contentDt) {
		this.contentDt = contentDt;
	}
	public ZonedDateTime getRefDt1() {
		return refDt1;
	}
	public void setRefDt1(ZonedDateTime refDt1) {
		this.refDt1 = refDt1;
	}
	public ZonedDateTime getRefDt2() {
		return refDt2;
	}
	public void setRefDt2(ZonedDateTime refDt2) {
		this.refDt2 = refDt2;
	}
	public ZonedDateTime getExpiryDt() {
		return expiryDt;
	}
	public void setExpiryDt(ZonedDateTime expiryDt) {
		this.expiryDt = expiryDt;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
    
}
