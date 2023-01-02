package com.cbic.microservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cbic_doc_mst")
public class CbicDocMst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isActive;
	private Date createdDt;
	private Date updatedDt;
	private Long createdBy;
	private Long updatedBy;
	private Long versionNo;
	private String isPublished;
	private Date publishDt;
	private String isArchived;
	private Date archiveDt;
	private Long parentId;
	private Long taxId;
	private Long locationId;
	private String docType;
	private String docNo;
	private String docTitleEn;
	private String docTitleHi;
	private String fileType;
	private String fileNameEn;
	private String fileNameHi;
	private String filePathEn;
	private String filePathHi;
	private String image;
	private Date documentDt;
	private Date ref_dt_1;
	private Date ref_dt_2;
	private Date expiryDt;
	private Long year;
	private Long contentTypeId;
	private Long contentId;
	
	@OneToOne
	@JoinColumn(name = "requestId")
	private RequestDetails requestDetails;
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private RequestDetails orderId;
	
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
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
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
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getDocTitleEn() {
		return docTitleEn;
	}
	public void setDocTitleEn(String docTitleEn) {
		this.docTitleEn = docTitleEn;
	}
	public String getDocTitleHi() {
		return docTitleHi;
	}
	public void setDocTitleHi(String docTitleHi) {
		this.docTitleHi = docTitleHi;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileNameEn() {
		return fileNameEn;
	}
	public void setFileNameEn(String fileNameEn) {
		this.fileNameEn = fileNameEn;
	}
	public String getFileNameHi() {
		return fileNameHi;
	}
	public void setFileNameHi(String fileNameHi) {
		this.fileNameHi = fileNameHi;
	}
	public String getFilePathEn() {
		return filePathEn;
	}
	public void setFilePathEn(String filePathEn) {
		this.filePathEn = filePathEn;
	}
	public String getFilePathHi() {
		return filePathHi;
	}
	public void setFilePathHi(String filePathHi) {
		this.filePathHi = filePathHi;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDocumentDt() {
		return documentDt;
	}
	public void setDocumentDt(Date documentDt) {
		this.documentDt = documentDt;
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
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}
	public RequestDetails getOrderId() {
		return orderId;
	}
	public void setOrderId(RequestDetails orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "CbicDocMst [id=" + id + ", isActive=" + isActive + ", createdDt=" + createdDt + ", updatedDt="
				+ updatedDt + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", versionNo=" + versionNo
				+ ", isPublished=" + isPublished + ", publishDt=" + publishDt + ", isArchived=" + isArchived
				+ ", archiveDt=" + archiveDt + ", parentId=" + parentId + ", taxId=" + taxId + ", locationId="
				+ locationId + ", docType=" + docType + ", docNo=" + docNo + ", docTitleEn=" + docTitleEn
				+ ", docTitleHi=" + docTitleHi + ", fileType=" + fileType + ", fileNameEn=" + fileNameEn
				+ ", fileNameHi=" + fileNameHi + ", filePathEn=" + filePathEn + ", filePathHi=" + filePathHi
				+ ", image=" + image + ", documentDt=" + documentDt + ", ref_dt_1=" + ref_dt_1 + ", ref_dt_2="
				+ ref_dt_2 + ", expiryDt=" + expiryDt + ", year=" + year + ", contentTypeId=" + contentTypeId
				+ ", contentId=" + contentId + ", requestDetails=" + requestDetails + ", orderId=" + orderId + "]";
	}
}
