package com.cbic.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbic.microservices.dto.Workflow;
import com.cbic.microservices.service.WorkflowService;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

	@Autowired
	private WorkflowService workflowService;
	
	@GetMapping("/getWorkflow")
	public List<Workflow> getWorkflow(){
		return workflowService.getWorkflow();
	}
}
