package com.trial.ims.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "internapplication")
public class InternApplication {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotNull
	@Size(min=2, max=20)
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only characters are allowed")
    @Column(name = "first_name")
    private String firstName;

	@NotNull
	@Size(min=2, max=20)
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only characters are allowed")
    @Column(name = "last_name")
    private String lastName;

	@NotNull
	@Size(min = 10, max = 10, message = "Contact number must be exactly 10 characters")
	@Pattern(regexp = "^[0-9]+$", message = "Only integers are allowed")
    @Column(name = "contact_number")
    private String contactNo;

	@NotNull
	@Email
    @Column(name = "email")
    private String email;

	@NotNull
    @Column(name = "collegeName")
    private String collegeName;
    
	@NotNull
	@Column(name = "branch_name")
    private String branch;
	
	@NotNull
	@Pattern(regexp = ".*\\.pdf$", message = "File must be a PDF with extension '.pdf'")
	@Column(name = "icard_image", length = 1000)
    private String icardImage;
    
	@NotNull
	@Pattern(regexp = ".*\\.pdf$", message = "File must be a PDF with extension '.pdf'")
    @Column(name = "noc_pdf", length = 1000)
    private String nocPdf;
    
	@NotNull
	@Min(value = 1, message = "Enter a value greater than or equal to 1")
    @Max(value = 8, message = "Enter a value less than or equal to 8")
    @Column(name = "semester")
    private int semester;

	@NotNull
	@Pattern(regexp = ".*\\.pdf$", message = "File must be a PDF with extension '.pdf'")
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
