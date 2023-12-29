package com.trial.ims.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "internapplication")
public class InternApplication {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "collegeName")
    private String collegeName;
    
	@Column(name = "branch_name")
    private String branch;
	
	@Column(name = "icard_image", length = 1000)
    private String icardImage;
    
    @Column(name = "noc_pdf", length = 1000)
    private String nocPdf;
    
    @Column(name = "semester")
    private int semester;

	@Column(name = "resume_pdf", length = 1000)
	private String resumePdf;
	
	@Column(name = "status")
	private String status;	
	
	public InternApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternApplication(Long id, String firstName, String lastName, String contactNo, String email,
			String collegeName, String branch, String icardImage, String nocPdf, int semester, String resumePdf) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.collegeName = collegeName;
		this.branch = branch;
		this.icardImage = icardImage;
		this.nocPdf = nocPdf;
		this.semester = semester;
		this.resumePdf = resumePdf;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIcardImage() {
		return icardImage;
	}

	public void setIcardImage(String icardImage) {
		this.icardImage = icardImage;
	}

	public String getNocPdf() {
		return nocPdf;
	}

	public void setNocPdf(String nocPdf) {
		this.nocPdf = nocPdf;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getResumePdf() {
		return resumePdf;
	}

	public void setResumePdf(String resumePdf) {
		this.resumePdf = resumePdf;
	}
    

}
