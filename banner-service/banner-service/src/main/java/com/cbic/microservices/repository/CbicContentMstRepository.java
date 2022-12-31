package com.cbic.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cbic.microservices.entity.CbicContentMst;

public interface CbicContentMstRepository extends JpaRepository<CbicContentMst, Integer>{
	
	@Query("select c from CbicContentMst c where c.requestDetails.requestNo = :requestId ")
	CbicContentMst findByRequestId(Integer requestId);

}
