package com.cbic.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.entity.RequestDetails;
import com.cbic.microservices.repository.RequestDetailsRepository;

@Service
public class RequestDetailsServiceImpl implements RequestDetailsService{

	@Autowired
	private RequestDetailsRepository requestDetailsRepository; 
	
	@Override
	public RequestDetails saveRequestDetails(RequestDetails requestDetails) {
		RequestDetails details = null;
		try {
			details = requestDetailsRepository.save(requestDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

	@Override
	public List<RequestDetails> getAllRequestDetails() {
		List<RequestDetails> requestDetails = null;
		try {
			requestDetails = requestDetailsRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestDetails;
	}

	@Override
	public RequestDetails getRequestDetailsById(Integer requestNo) {
		Optional<RequestDetails> findById = null;
		try {
			findById = requestDetailsRepository.findById(requestNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != findById && null != findById.get()) {
			return findById.get();
		}
		return null;
	}

}
