package com.trial.ims.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.trial.ims.entities.Intern;
import com.trial.ims.entities.InternApplication;
import com.trial.ims.repositories.InternApplicationRepo;
import com.trial.ims.services.EmailSenderService;

@Controller
@Validated
public class HomeController {
	
	private InternApplicationRepo repo;
	private EmailSenderService emailService;
	
	
	@org.springframework.beans.factory.annotation.Value("${icard.filepath}")
	private String icardfolderpath;
	@org.springframework.beans.factory.annotation.Value("${noc.filepath}")
	private String nocfolderpath;
	@org.springframework.beans.factory.annotation.Value("${resume.filepath}")
	private String resumefolderpath;
	
	public HomeController(InternApplicationRepo repo, EmailSenderService emailService) {
		this.repo = repo;
		this.emailService = emailService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/intern_login")
	public void login() {

	}

	@PostMapping("/intern_login")
	public void login(Intern intern) {

	}
	
	@GetMapping("/admin_register")
	public String admin_register() {
		return "adminregistration";
	}
	
	@PostMapping("/admin_register")
	public String admin_register(MultipartHttpServletRequest req) {
		return "adminregistration";
	}
	
	

	@GetMapping("/bisag_internship")
	public String bisag_internship() {
		return "internapply";
	}

	@PostMapping("/bisag_internship")
	public String bisag_iternship(MultipartHttpServletRequest req, InternApplication intern)
			throws IllegalStateException, Exception {

		
		//upload noc and image
		intern.setIcardImage(uploadfile(req.getFile("icardImageone"), "icard"));
		intern.setNocPdf(uploadfile(req.getFile("nocPdfone"), "noc"));
		intern.setResumePdf(uploadfile(req.getFile("resumePdfone"), "resume"));
		repo.save(intern);
		emailService.sendSimpleEmail(intern.getEmail(), "You have successfully applied for bisag internship!", "BISAG INTERNSHIP");
		return "index";
	}

	public String uploadfile(MultipartFile file, String object) throws Exception, IllegalStateException, IOException {
		try {
			if(object == "icard")
			{
				File myDir = new File(icardfolderpath);
				if (!myDir.exists())
					myDir.mkdirs();
				long timeadd = System.currentTimeMillis();

				if (!file.isEmpty()) {
					file.transferTo(Paths.get(myDir.getAbsolutePath(), timeadd + "_" + file.getOriginalFilename()));
					return timeadd + "_" + file.getOriginalFilename();
				} else {
					return null;
				}
			}
			else if (object == "noc")
			{
				File myDir = new File(nocfolderpath);
				if (!myDir.exists())
					myDir.mkdirs();
				long timeadd = System.currentTimeMillis();

				if (!file.isEmpty()) {
					file.transferTo(Paths.get(myDir.getAbsolutePath(), timeadd + "_" + file.getOriginalFilename()));
					return timeadd + "_" + file.getOriginalFilename();
				} else {
					return null;
				}
			}
			else if (object.equals("resume")) {
			    File myDir = new File(resumefolderpath);
			    
			    // Ensure the directory exists, create it if it doesn't
			    if (!myDir.exists()) {
			        myDir.mkdirs();
			    }

			    long timeadd = System.currentTimeMillis();

			    if (!file.isEmpty()) {
			        // Construct the full file path
			        String fullFilePath = myDir.getAbsolutePath() + File.separator + timeadd + "_" + file.getOriginalFilename();

			        // Print the full file path for debugging
			        System.out.println("Full File Path: " + fullFilePath);

			        try {
			            // Transfer the file to the specified path
			            file.transferTo(Paths.get(fullFilePath));
			            return timeadd + "_" + file.getOriginalFilename();
			        } catch (IOException e) {
			            e.printStackTrace();
			            // Handle the exception accordingly
			            return null;
			        }
			    } else {
			        return null;
			    }
			}

			/*
			 * else if (object == "resume") { File myDir = new File(resumefolderpath); if
			 * (!myDir.exists()) myDir.mkdirs(); long timeadd = System.currentTimeMillis();
			 * 
			 * if (!file.isEmpty()) { file.transferTo(Paths.get(myDir.getAbsolutePath(),
			 * timeadd + "_" + file.getOriginalFilename())); return timeadd + "_" +
			 * file.getOriginalFilename(); } else { return null; } }
			 */
			else 
			{
				System.out.println("nothing is true");
				return "redirect:index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:index";
		}
		
	}
}