package com.cbic.microservices.tickerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbic.microservices.tickerservice.dto.WorkflowMasterDTO;

public interface WorkflowMasterRepository extends JpaRepository<WorkflowMasterDTO,Integer>{

	@Query(value  = "Select * from WorkflowMasterDTO where workflow_name = :workflowName", nativeQuery = true)
	WorkflowMasterDTO findWorkflowMaster(@Param("workflowName") String workflowName);
}
