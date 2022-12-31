package com.cbic.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cbic.microservices.entity.CbicDocMst;

public interface CbicDocMstRepository extends JpaRepository<CbicDocMst, Long>{

	@Query("select c from CbicDocMst c where c.requestDetails.requestNo = :requestId ")
	CbicDocMst findByRequestId(Integer requestId);
}
