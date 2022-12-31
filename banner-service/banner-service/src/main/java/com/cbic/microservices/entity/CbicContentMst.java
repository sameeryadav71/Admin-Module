package com.cbic.microservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@DataSourceDefinition()
@Entity
@Table(name = "cbic_content_mst")
public class CbicContentMst {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String isActive;
	private Integer orderId;
	private Date createdDt;
	private Date updatedDt;
	private Long updateBy;
	private Long versionNo;
	private String isPublished;
	private Date publishDt;
	private String isArchived;
	private Date archiveDt;
	private Long parentId;
	private Long taxId;
	private Long locationId;
	private String titleEn;
	private String titleHi;
	private String infoEn;
	private String infoHi;
	private String refNumber;
	private String path;
	private Date contentDt;
	private Date ref_dt_1;
	private Date ref_dt_2;
	private Date expiryDt;
	private Long year;
	private Long contentTypeId;
	
	@OneToOne
	@JoinColumn(name = "requestId")
	private RequestDetails requestDetails;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public Date getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
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
	public Date getPublishDt() {
		return publishDt;
	}
	public void setPublishDt(Date publishDt) {
		this.publishDt = publishDt;
	}
	public String getIsArchived() {
		return isArchived;
	}
	public void setIsArchived(String isArchived) {
		this.isArchived = isArchived;
	}
	public Date getArchiveDt() {
		return archiveDt;
	}
	public void setArchiveDt(Date archiveDt) {
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
	public Date getContentDt() {
		return contentDt;
	}
	public void setContentDt(Date contentDt) {
		this.contentDt = contentDt;
	}
	public Date getRef_dt_1() {
		return ref_dt_1;
	}
	public void setRef_dt_1(Date ref_dt_1) {
		this.ref_dt_1 = ref_dt_1;
	}
	public Date getRef_dt_2() {
		return ref_dt_2;
	}
	public void setRef_dt_2(Date ref_dt_2) {
		this.ref_dt_2 = ref_dt_2;
	}
	public Date getExpiryDt() {
		return expiryDt;
	}
	public void setExpiryDt(Date expiryDt) {
		this.expiryDt = expiryDt;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Long contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}
	@Override
	public String toString() {
		return "CbicContentMst [id=" + id + ", isActive=" + isActive + ", orderId=" + orderId + ", createdDt="
				+ createdDt + ", updatedDt=" + updatedDt + ", updateBy=" + updateBy + ", versionNo=" + versionNo
				+ ", isPublished=" + isPublished + ", publishDt=" + publishDt + ", isArchived=" + isArchived
				+ ", archiveDt=" + archiveDt + ", parentId=" + parentId + ", taxId=" + taxId + ", locationId="
				+ locationId + ", titleEn=" + titleEn + ", titleHi=" + titleHi + ", infoEn=" + infoEn + ", infoHi="
				+ infoHi + ", refNumber=" + refNumber + ", path=" + path + ", contentDt=" + contentDt + ", ref_dt_1="
				+ ref_dt_1 + ", ref_dt_2=" + ref_dt_2 + ", expiryDt=" + expiryDt + ", year=" + year + ", contentTypeId="
				+ contentTypeId + ", requestDetails=" + requestDetails + "]";
	}

}
