package com.cbic.microservices.service;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.dto.ValidatorView;

public interface ValidatorService {

	public Banner getBannerByRequestId(Integer requestId);
	public ValidatorView getValidatorViewByRequestId(Integer requestId);
	public ValidatorView saveValidatorCommentAndStatus(ValidatorView validatorView);
}
