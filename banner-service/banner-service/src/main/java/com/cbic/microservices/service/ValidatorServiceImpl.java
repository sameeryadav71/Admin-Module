package com.cbic.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.dto.ValidatorView;
import com.cbic.microservices.entity.CbicContentMst;
import com.cbic.microservices.entity.RequestActionDetail;
import com.cbic.microservices.util.BannerUtil;

@Service
public class ValidatorServiceImpl implements ValidatorService {

	@Autowired
	private CbicContentMstService cbicContentMstService;

	@Autowired
	private RequestActionDetailService requestActionDetailService;

	@Override
	public Banner getBannerByRequestId(Integer requestId) {
		Banner banner = new Banner();
		CbicContentMst cbicContentMst = null;
		try {
			cbicContentMst = cbicContentMstService.getCbicContentMstByRequestId(requestId);
			banner.setCbicContentMst(cbicContentMst);
			banner = BannerUtil.saveCbicContentMst(cbicContentMst);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return banner;
	}

	@Override
	public ValidatorView getValidatorViewByRequestId(Integer requestId) {
		ValidatorView validatorView = null;
		CbicContentMst cbicContentMst = null;
		RequestActionDetail requestActionDetail = null;
		try {
			cbicContentMst = cbicContentMstService.getCbicContentMstByRequestId(requestId);
			if (null != cbicContentMst) {
				validatorView = BannerUtil.saveValidatorView(cbicContentMst);
				requestActionDetail = requestActionDetailService.getRequestActionDetailByRequestId(requestId);
				if (null != validatorView && null != requestActionDetail)
					validatorView.setComment(requestActionDetail.getComment());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validatorView;
	}

	@Override
	public ValidatorView saveValidatorCommentAndStatus(ValidatorView validatorView) {
		RequestActionDetail requestActionDetail = null;
		try {
			requestActionDetail = requestActionDetailService.getRequestActionDetailByRequestId(validatorView.getRequestId());
			if(null!=requestActionDetail) {
				requestActionDetail.setComment(validatorView.getComment());
				requestActionDetail.setStatus("Approved by Validator");
				requestActionDetail.setWfLevel(1);
				requestActionDetail.setActionId(2);
				requestActionDetail = requestActionDetailService.saveRequestActionDetail(requestActionDetail);
				return validatorView;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
