package com.cbic.microservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbic.microservices.dto.Workflow;
import com.cbic.microservices.entity.RequestDetails;
import com.cbic.microservices.util.BannerUtil;

@Service
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private RequestDetailsService requestDetailsService;

	@Override
	public List<Workflow> getWorkflow() {
		List<Workflow> list = new ArrayList<>();
		List<RequestDetails> allRequestDetails = null;
		try {
			allRequestDetails = requestDetailsService.getAllRequestDetails();
			if (!allRequestDetails.isEmpty()) {
				allRequestDetails.forEach(e -> {
					Workflow workflow = BannerUtil.getWorkflow(e);
					list.add(workflow);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
