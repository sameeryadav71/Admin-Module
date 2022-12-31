package com.cbic.microservices.tickerservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "workflow_details_mst")
public class WorkflowDetailsMasterDTO {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workflow_id", updatable = false)
	private String workflowId;
	
	@Column(name = "workflow_level", updatable = false)
	@NotNull
	private int workflowLevel;
	
	@Column(name = "workflow_level_description", updatable = false)
	private String workflowLevelDescription;
	
	@Column(name = "role_id", updatable = false)
	@NotNull
	private int roleId;
	
	@Column(name = "isactive", updatable = false)
	@NotNull
	private int isactive;

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public int getWorkflowLevel() {
		return workflowLevel;
	}

	public void setWorkflowLevel(int workflowLevel) {
		this.workflowLevel = workflowLevel;
	}

	public String getWorkflowLevelDescription() {
		return workflowLevelDescription;
	}

	public void setWorkflowLevelDescription(String workflowLevelDescription) {
		this.workflowLevelDescription = workflowLevelDescription;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
	
}
