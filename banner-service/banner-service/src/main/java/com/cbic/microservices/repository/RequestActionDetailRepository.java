package com.cbic.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cbic.microservices.entity.RequestActionDetail;

public interface RequestActionDetailRepository extends JpaRepository<RequestActionDetail, Integer>{

	@Query("select c from RequestActionDetail c where c.requestDetails.requestNo = :requestId ")
	RequestActionDetail findByRequestId(Integer requestId);

}
