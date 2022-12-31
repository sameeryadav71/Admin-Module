package com.cbic.microservices.tickerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbic.microservices.tickerservice.dto.RequestActionDetailDTO;

@Repository
public interface RequestActionDetailsRepository  extends JpaRepository<RequestActionDetailDTO,Integer>{

}
