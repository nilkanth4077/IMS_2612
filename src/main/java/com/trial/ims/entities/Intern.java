package com.trial.ims.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "intern")
public class Intern {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intern_id")
    private String internId;

    @Column(name = "name")
    private String name;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact_no")
    private Long contactNo;

    @Column(name = "email_id", unique = true)
    private String emailId;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_guide_hod_name")
    private String collegeGuideHodName;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "aggregate_percentage")
    private Double aggregatePercentage;

   
	@Column(name = "project_definition_name")
    private String projectDefinitionName;

    @Column(name = "guide_name")
    private String guideName;

    @Column(name = "programming_lang_name")
    private String programmingLangName;

    @Column(name = "joining_date")
    private String joiningDate;

    @Column(name = "completion_date")
    private String completionDate;

    @Column(name = "used_resource", columnDefinition = "TEXT")
    private String usedResource;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = true)
    private Date updatedAt;

    public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intern(String internId, String name, String permanentAddress, String dateOfBirth, String gender,
			Long contactNo, String emailId, String collegeName, String collegeGuideHodName, String universityName,
			String degree, String branchName, Double aggregatePercentage, String projectDefinitionName,
			String guideName, String programmingLangName, String joiningDate, String completionDate,
			String usedResource, Date createdAt, Date updatedAt) {
		super();
		this.internId = internId;
		this.name = name;
		this.permanentAddress = permanentAddress;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.collegeName = collegeName;
		this.collegeGuideHodName = collegeGuideHodName;
		this.universityName = universityName;
		this.degree = degree;
		this.branchName = branchName;
		this.aggregatePercentage = aggregatePercentage;
		this.projectDefinitionName = projectDefinitionName;
		this.guideName = guideName;
		this.programmingLangName = programmingLangName;
		this.joiningDate = joiningDate;
		this.completionDate = completionDate;
		this.usedResource = usedResource;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
}

	public String getInternId() {
		return internId;
	}

	public void setInternId(String internId) {
		this.internId = internId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeGuideHodName() {
		return collegeGuideHodName;
	}

	public void setCollegeGuideHodName(String collegeGuideHodName) {
		this.collegeGuideHodName = collegeGuideHodName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Double getAggregatePercentage() {
		return aggregatePercentage;
	}

	public void setAggregatePercentage(Double aggregatePercentage) {
		this.aggregatePercentage = aggregatePercentage;
	}

	public String getProjectDefinitionName() {
		return projectDefinitionName;
	}

	public void setProjectDefinitionName(String projectDefinitionName) {
		this.projectDefinitionName = projectDefinitionName;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public String getProgrammingLangName() {
		return programmingLangName;
	}

	public void setProgrammingLangName(String programmingLangName) {
		this.programmingLangName = programmingLangName;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getUsedResource() {
		return usedResource;
	}

	public void setUsedResource(String usedResource) {
		this.usedResource = usedResource;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 @PrePersist
	    protected void onCreate() {
	       createdAt = new Date();
	    }


}
