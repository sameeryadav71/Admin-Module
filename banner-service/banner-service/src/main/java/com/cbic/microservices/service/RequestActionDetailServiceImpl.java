package com.cbic.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.entity.RequestActionDetail;
import com.cbic.microservices.repository.RequestActionDetailRepository;

@Service
public class RequestActionDetailServiceImpl implements RequestActionDetailService{

	@Autowired
	private RequestActionDetailRepository requestActionDetailRepository;
	
	@Override
	public RequestActionDetail saveRequestActionDetail(RequestActionDetail requestActionDetail) {
		RequestActionDetail actionDetail = null;
		try {
			actionDetail = requestActionDetailRepository.save(requestActionDetail);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return actionDetail;
	}

	@Override
	public List<RequestActionDetail> getAllRequestActionDetail() {
		List<RequestActionDetail> requestActionDetails = null;
		try {
			requestActionDetails = requestActionDetailRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestActionDetails;
	}

	@Override
	public RequestActionDetail getRequestActionDetailById(Integer actionId) {
		Optional<RequestActionDetail> findById = null;
		try {
			findById = requestActionDetailRepository.findById(actionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != findById && null != findById.get()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public RequestActionDetail getRequestActionDetailByRequestId(Integer requestId) {
		RequestActionDetail findById = null;
		try {
			findById = requestActionDetailRepository.findByRequestId(requestId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findById;
	}

}
