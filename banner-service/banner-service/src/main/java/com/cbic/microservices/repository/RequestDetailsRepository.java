package com.cbic.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbic.microservices.entity.RequestDetails;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Integer>{

}
