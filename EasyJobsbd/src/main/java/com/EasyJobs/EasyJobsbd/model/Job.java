package com.EasyJobs.EasyJobsbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int JobId;
	@Column
	private String JobTitle;
	@Column
	private String CompanyName;
	@Column
	private String JobDescription;
	@Column
	private String JobSkillsRequired;
	@Column
	private String JobLocation;
	@Column
	private int SalaryPerMonth;
	@Column
	private String ExperienceRequired;
	
	
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public String getJobSkillsRequired() {
		return JobSkillsRequired;
	}
	public void setJobSkillsRequired(String jobSkillsRequired) {
		JobSkillsRequired = jobSkillsRequired;
	}
	public String getJobLocation() {
		return JobLocation;
	}
	public void setJobLocation(String jobLocation) {
		JobLocation = jobLocation;
	}
	public int getSalaryPerMonth() {
		return SalaryPerMonth;
	}
	public void setSalaryPerMonth(int salaryPerMonth) {
		SalaryPerMonth = salaryPerMonth;
	}
	public String getExperienceRequired() {
		return ExperienceRequired;
	}
	public void setExperienceRequired(String experienceRequired) {
		ExperienceRequired = experienceRequired;
	}

}
