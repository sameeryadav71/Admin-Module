package com.cbic.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.dto.ValidatorView;
import com.cbic.microservices.service.ValidatorService;

@RestController
@RequestMapping("/validator")
public class ValidatorController {

	@Autowired
	private ValidatorService validatorService;
	
	@GetMapping("/getValidatorPageByRequestId/{requestId}")
	public Banner getBannerByRequestId(@PathVariable("requestId")Integer requestId) {
		return validatorService.getBannerByRequestId(requestId);
	}
	
	@GetMapping("/getValidatorViewByRequestId/{requestId}")
	public ValidatorView getValidatorViewByRequestId(@PathVariable("requestId")Integer requestId) {
		return validatorService.getValidatorViewByRequestId(requestId);
	}
	
	@PostMapping("/saveCommentAndStatusOfValidator")
	public ValidatorView saveValidatorCommentAndStatus(@RequestBody ValidatorView validatorView) {
		return validatorService.saveValidatorCommentAndStatus(validatorView);
	}

}
