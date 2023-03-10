package com.cbic.microservices.util;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.dto.ValidatorView;
import com.cbic.microservices.dto.Workflow;
import com.cbic.microservices.entity.CbicContentMst;
import com.cbic.microservices.entity.RequestDetails;

public class BannerUtil {

	private static final String BANNER = "Banner";
	private static final String PENDING = "PENDING";
	private static final String Y = "Y";
	private static final Integer WORKFLOW_LEVEL = 0;
	private static final Long VERSION_NO = 1L;
	private static final String SEPARATOR = "/";
	private static final String ADMIN = "ADMIN";
	private static final String CBIC = "CBIC";


	public static Banner getBannerDeatils(Banner banner) {

		// setting requestDetails data
		banner.getRequestDetails().setDescription(banner.getBannerDesription());
		banner.getRequestDetails().setRequestType(BANNER);
		banner.getRequestDetails().setContentTypeId(2);
		banner.getRequestDetails().setWorkflowLevel(WORKFLOW_LEVEL);
		banner.getRequestDetails().setRequestedOn(banner.getCreatedDate());
		banner.getRequestDetails().setRequestStatus(PENDING);
		banner.getRequestDetails().setRequestedBy(ADMIN);

		// setting cbicDocMst data
		banner.getCbicDocMst().setCreatedDt(banner.getCreatedDate());
		banner.getCbicDocMst().setVersionNo(VERSION_NO);
		banner.getCbicDocMst().setIsPublished(Y);
		banner.getCbicDocMst().setDocType(BANNER);
		banner.getCbicDocMst().setDocNo(banner.getBannerName());
		banner.getCbicDocMst().setDocTitleEn(banner.getBannerDesription());
		banner.getCbicDocMst().setFileType(BANNER);
		banner.getCbicDocMst().setFileNameEn(banner.getBannerName());
		banner.getCbicDocMst().setFilePathEn(banner.getImagePath());
		banner.getCbicDocMst().setImage(banner.getBannerName());
		banner.getCbicDocMst().setDocumentDt(banner.getCreatedDate());
		banner.getCbicDocMst().setExpiryDt(banner.getEndDate());
		banner.getCbicDocMst().setRequestDetails(banner.getRequestDetails());
		banner.getCbicDocMst().setOrderId(banner.getRequestDetails());
		banner.getCbicDocMst().setCreatedBy(59380l);
		
		// setting cbicContentMst data
		banner.getCbicContentMst().setIsActive(Y);
		banner.getCbicContentMst().setOrderId(banner.getPriority());
		banner.getCbicContentMst().setCreatedDt(banner.getCreatedDate());
		banner.getCbicContentMst().setCreatedBy(59380l);
		banner.getCbicContentMst().setVersionNo(VERSION_NO);
		banner.getCbicContentMst().setIsPublished(Y);
		banner.getCbicContentMst().setYear(2023l);
		banner.getCbicContentMst().setTitleEn(banner.getBannerDesription());
		banner.getCbicContentMst().setInfoEn(banner.getBannerDesription());
		banner.getCbicContentMst().setPath(banner.getImagePath());
		banner.getCbicContentMst().setContentDt(banner.getStartDate());
		banner.getCbicContentMst().setExpiryDt(banner.getEndDate());
		banner.getCbicContentMst().setContentTypeId(2l);
		banner.getCbicContentMst().setRequestDetails(banner.getRequestDetails());

		// setting requestActionDetail data
		banner.getRequestActionDetail().setWfLevel(WORKFLOW_LEVEL);
		banner.getRequestActionDetail().setStatus(PENDING);
		banner.getRequestActionDetail().setComment(banner.getBannerDesription());
		banner.getRequestActionDetail().setCreatedOn(banner.getCreatedDate());
		banner.getRequestActionDetail().setRequestDetails(banner.getRequestDetails());
		banner.getRequestActionDetail().setCreatedBy(ADMIN);
		
		return banner;
	}

	public static Banner saveCbicContentMst(CbicContentMst cbicContentMst) {
		Banner banner = new Banner();
		banner.setCbicContentMst(cbicContentMst);
		banner.setRequestDetails(cbicContentMst.getRequestDetails());
		banner.setBannerDesription(cbicContentMst.getTitleEn());
		banner.setImagePath(cbicContentMst.getPath());
		banner.setPriority(cbicContentMst.getOrderId());
		banner.setStartDate(cbicContentMst.getContentDt());
		banner.setEndDate(cbicContentMst.getExpiryDt());
		banner.setCreatedDate(cbicContentMst.getCreatedDt());
		banner.setBannerName(getFileNameFromPath(cbicContentMst.getPath()));
		return banner;
	}

	public static String getFileNameFromPath(String filePath) {
		if (null != filePath && filePath.contains(SEPARATOR)) {
			return filePath.substring(filePath.indexOf(SEPARATOR) + SEPARATOR.length());
		}
		return null;
	}
	
	public static ValidatorView saveValidatorView(CbicContentMst cbicContentMst) {
		ValidatorView validatorView = new ValidatorView();
		validatorView.setDesription(cbicContentMst.getTitleEn());
		validatorView.setEndDate(cbicContentMst.getExpiryDt());
		validatorView.setStartDate(cbicContentMst.getCreatedDt());
		validatorView.setFile(cbicContentMst.getPath());
		validatorView.setPriority(cbicContentMst.getOrderId());
		validatorView.setRequestId(cbicContentMst.getRequestDetails().getRequestNo());
		return validatorView;
	}
	
	public static Workflow getWorkflow(RequestDetails requestDetails) {
		Workflow workflow = new Workflow();
		workflow.setApplicationName(CBIC);
		workflow.setRequestNo(requestDetails.getRequestNo());
		workflow.setRequestType(requestDetails.getRequestType());
		workflow.setContentType(requestDetails.getRequestType());
		workflow.setStatus(requestDetails.getRequestStatus());
		workflow.setInitiatedOn(requestDetails.getRequestedOn());
		workflow.setInitiatedBy(requestDetails.getRequestedBy());
		workflow.setUpdatedOn(requestDetails.getUpdatedOn());
		return workflow;
	}

}
