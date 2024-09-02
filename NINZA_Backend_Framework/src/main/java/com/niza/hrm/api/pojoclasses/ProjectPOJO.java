package com.niza.hrm.api.pojoclasses;

public class ProjectPOJO
{
	String projectName;
	String status;
	int teamSize;
	String createdBy;
	
	public ProjectPOJO()
	{
		
	}
	
	public ProjectPOJO(String projectName, String status, int teamSize, String createdBy) {
		super();
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
