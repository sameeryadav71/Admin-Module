package com.cbic.microservices.service;

import java.util.List;

import com.cbic.microservices.entity.RequestDetails;

public interface RequestDetailsService {

	public RequestDetails saveRequestDetails(RequestDetails requestDetails);
	public List<RequestDetails> getAllRequestDetails();
	public RequestDetails getRequestDetailsById(Integer requestNo);
}
