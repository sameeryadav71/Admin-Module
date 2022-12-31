package com.cbic.microservices.service;

import java.util.List;

import com.cbic.microservices.entity.RequestActionDetail;

public interface RequestActionDetailService {

	public RequestActionDetail saveRequestActionDetail(RequestActionDetail requestActionDetail);
	public List<RequestActionDetail> getAllRequestActionDetail();
	public RequestActionDetail getRequestActionDetailById(Integer actionId);
	public RequestActionDetail getRequestActionDetailByRequestId(Integer requestId);

}
