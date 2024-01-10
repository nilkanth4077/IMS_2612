package com.trial.ims.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "guide")
public class Guide {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private Long guideId;

	@NotNull
	@Size(min=2, max=20)
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Only characters are allowed")
    @Column(name = "name")
    private String name;

	@NotNull
	@Size(min=2, max=20)
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Only characters are allowed")
    @Column(name = "location")
    private String location;
    
	@NotNull
	@Digits(integer = 10, fraction = 0, message = "Contact number must be a numeric value with up to 10 digits")
    @Column(name = "floor")
    private Long floor;
    
	@NotNull
	@Digits(integer = 10, fraction = 0, message = "Contact number must be a numeric value with up to 10 digits")
    @Column(name = "lab_no")
    private Long labNo;

	@NotNull
	@Digits(integer = 10, fraction = 0, message = "Contact number must be a numeric value with up to 10 digits")
    @Column(name = "contact_no")
    private Long contactNo;

	@Email
    @Column(name = "email_id", unique = true)
    private String emailId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date createdAt;

    public Guide() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guide(Long guideId, String name, String location, Long floor, Long labNo,
			Long contactNo, String emailId, Date createdAt) {
		super();
		this.guideId = guideId;
		this.name = name;
		this.location = location;
		this.floor = floor;
		this.labNo = labNo;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.createdAt = createdAt;
}

	public Long getGuideId() {
		return guideId;
	}

	public void setGuideId(Long guideId) {
		this.guideId = guideId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}
	
	public Long getLabNo() {
		return labNo;
	}

	public void setLabNo(Long labNo) {
		this.labNo = labNo;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
