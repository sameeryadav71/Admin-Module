package com.cbic.microservices.tickerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbic.microservices.tickerservice.dto.RequestDetailsDTO;

@Repository
public interface RequestDetailsRepository extends JpaRepository<RequestDetailsDTO,Integer>{

}
