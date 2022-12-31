package com.cbic.microservices.tickerservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sun.istack.NotNull;

@Entity
@Table(name = "cbic_content_mst")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CbicContentMasterDTO {
    @Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "created_dt")
    private String createdDt;

    @Column(name = "updated_dt")
    private String updatedDt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "update_by")
    private Long updateBy;

    @Column(name = "version_no")
    private Long versionNo;

    @Column(name = "is_published")
    private String isPublished;

    @Column(name = "publish_dt")
    private String publishDt;

    @Column(name = "is_archived")
    private String isArchived;

    @Column(name = "archive_dt")
    private String archiveDt;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "tax_id")
    private Long taxId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_hi")
    private String titleHi;

    @Column(name = "info_en")
    private String infoEn;

    @Column(name = "info_hi")
    private String infoHi;

    @Column(name = "ref_number")
    private String refNumber;

    @Column(name = "path")
    private String path;

    @Column(name = "content_dt")
    private String contentDt;

    @Column(name = "ref_dt_1")
    private String refDt1;

    @Column(name = "ref_dt_2")
    private String refDt2;

    @Column(name = "expiry_dt")
    private String expiryDt;

    @Column(name = "year")
    private Long year;
    
    @Column(name = "content_type_id")
    private Long contentTypeId;
    
    @Column(name = "request_id")
    private Long requestId;

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

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public String getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(String updatedDt) {
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

	public String getPublishDt() {
		return publishDt;
	}

	public void setPublishDt(String publishDt) {
		this.publishDt = publishDt;
	}

	public String getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(String isArchived) {
		this.isArchived = isArchived;
	}

	public String getArchiveDt() {
		return archiveDt;
	}

	public void setArchiveDt(String archiveDt) {
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

	public String getContentDt() {
		return contentDt;
	}

	public void setContentDt(String contentDt) {
		this.contentDt = contentDt;
	}

	public String getRefDt1() {
		return refDt1;
	}

	public void setRefDt1(String refDt1) {
		this.refDt1 = refDt1;
	}

	public String getRefDt2() {
		return refDt2;
	}

	public void setRefDt2(String refDt2) {
		this.refDt2 = refDt2;
	}

	public String getExpiryDt() {
		return expiryDt;
	}

	public void setExpiryDt(String expiryDt) {
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

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
    
    

}
