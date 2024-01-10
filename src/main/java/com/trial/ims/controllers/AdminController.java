package com.trial.ims.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trial.ims.entities.Admin;
import com.trial.ims.entities.Intern;
import com.trial.ims.entities.InternApplication;
import com.trial.ims.repositories.AdminRepo;
import com.trial.ims.repositories.InternRepo;
import com.trial.ims.services.AdminService;
import com.trial.ims.services.EmailSenderService;
import com.trial.ims.services.InternService;

@Controller
@RequestMapping("/bisag/admin")
public class AdminController {
	
	@Autowired
	private InternService internService;
	@Autowired
	private AdminService adminService;
	
	private EmailSenderService emailService;
	private InternRepo irepo;
	private AdminRepo arepo;
	
	
	public AdminController(InternRepo irepo, AdminRepo arepo, EmailSenderService emailService) {
		// TODO Auto-generated constructor stub
		this.setIrepo(irepo);
		this.setArepo(arepo);
		this.emailService = emailService;
	}
	
//	(InternApplicationRepo repo, EmailSenderService emailService) {
//		this.repo = repo;
//		this.emailService = emailService;
//	}

	public String generateInternId() {
        // Generate custom internId using current year and serial number
        SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
        String currentYear = yearFormat.format(new Date());

        // Assuming you have a method to get the next serial number
        int serialNumber = generateSerialNumber();
        ++serialNumber;
        // Combine the parts to form the custom internId
        String sno = String.valueOf(serialNumber);
        String formattedSerialNumber = String.format("%04d", Integer.parseInt(sno));
        System.out.println("serialNumber..."+ serialNumber);
        System.out.println("formated..."+ formattedSerialNumber);
        String internId = currentYear + "BISAG" + formattedSerialNumber;
        return internId;
    }
	public int generateSerialNumber() {
		
		String id = internService.getMostRecentInternId();
		if(id==null)
			return 0;
		String serialNumber = id.substring(id.length() - 4);
		int lastFourDigits = Integer.parseInt(serialNumber);
        return lastFourDigits;
    }
	
	
	//------------------------------ Admin Dashboard ------------------------------//
	
	@GetMapping("/admin_dash")
	public String adminDash()
	{
		return "admin/admin_dash";
	}
	
	//--------------------------- Admin Dashboard Done ----------------------------//
	
	
	//Intern Registration///////////////////////////////////////////////
	
	@GetMapping("/register_intern")
	public String registerIntern()
	{
		return "admin/intern_registration";
	}
	
	@PostMapping("/register_intern")
	public String registerIntern(@ModelAttribute("intern") Intern intern)
	{
		intern.setInternId(generateInternId());
		internService.registerIntern(intern);
		emailService.sendSimpleEmail(
				intern.getEmailId(),
				"\r\n"
				+ "Dear " + intern.getName() + "\r\n"
				+ "\r\n"
				+ "We are pleased to inform you that you have been selected for the internship position. Your Intern ID is " + intern.getInternId() + ". We look forward to welcoming you to our team and trust that this experience will be mutually beneficial.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "BISAG-N",
				"BISAG INTERNSHIP"
		);
		
		return "redirect:/";
	}
	
	//----------------------------------- Admin registration ---------------------------------------//
	
	@GetMapping("/register_admin")
	public String registerAdmin()
	{
		return "admin/admin_registration";
	}
	
	@PostMapping("/register_admin")
	public String registerAdmin(@ModelAttribute("admin") Admin admin)
	{
		adminService.registerAdmin(admin);
		emailService.sendSimpleEmail(
				admin.getEmailId(),
				"Notification: Appointment as Administrator\r\n"
				+ "\r\n"
				+ "Dear " + admin.getName() + "\r\n"
				+ "\r\n"
				+ "I trust this email finds you well. We are pleased to inform you that you have been appointed as an administrator within our organization, effective immediately. Your dedication and contributions to the team have not gone unnoticed, and we believe that your new role will bring added value to our operations.\r\n"
				+ "\r\n"
				+ "As an administrator, you now hold a position of responsibility within the organization. We trust that you will approach your duties with diligence, professionalism, and a commitment to upholding the values of our organization.\r\n"
				+ "\r\n"
				+ "It is imperative to recognize the importance of your role and the impact it may have on the functioning of our team. We have confidence in your ability to handle the responsibilities that come with this position and to contribute positively to the continued success of our organization.\r\n"
				+ "\r\n"
				+ "We would like to emphasize the importance of maintaining the highest standards of integrity and ethics in your role. It is expected that you will use your administrative privileges responsibly and refrain from any misuse.\r\n"
				+ "\r\n"
				+ "Should you have any questions or require further clarification regarding your new responsibilities, please do not hesitate to reach out to [Contact Person/Department].\r\n"
				+ "\r\n"
				+ "Once again, congratulations on your appointment as an administrator. We look forward to your continued contributions and success in this elevated role.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "\r\n"
				+ "Your Colleague,\r\n"
				+ "Administrator\r\n"
				+ "1231231231",
				"BISAG ADMINISTRATIVE OFFICE"
		);
		
		return "redirect:/bisag/admin/admin_list";
	}
	
	public AdminRepo getArepo() {
		return arepo;
	}

	public void setArepo(AdminRepo arepo) {
		this.arepo = arepo;
	}

	//----------------------------- Admin registration Completed -----------------------------------//
	
	//--------------------------------------- Admin List -------------------------------------------//
	
	@GetMapping("/admin_list")
	public ModelAndView adminList()
	{
		ModelAndView mv = new ModelAndView("admin/admin_list");
		List<Admin> admins = adminService.getAdmin();
		mv.addObject("admins", admins);
		return mv;
	}
	@GetMapping("/admin_list/{id}")
	public ModelAndView adminList(@PathVariable("id") long id)
	{
		System.out.println("id"+id);
		ModelAndView mv = new ModelAndView();
		Optional<Admin> admin = adminService.getAdmin(id);
		mv.addObject("admin",admin);
		mv.setViewName("admin/admin_list_detail");
		return mv;
	}
	
	@PostMapping("/admin_list/ans")
	public String adminListRedirect()
	{
		System.out.println("iddd");
		return "redirect:/bisag/admin/admin_list";
	}
	
	//---------------------------------- Admin List Completed --------------------------------------//
	
	//-------------------------------------- Admin Update ------------------------------------------//
		
	@GetMapping("/update_admin/{id}")
	public ModelAndView updateAdmin(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("admin/update_admin");
		Optional<Admin> admin = adminService.getAdmin(id);
		mv.addObject("admin", admin.orElse(new Admin()));
//		adminService.deleteAdmin(id);
		return mv;
	}
	
	@PostMapping("/update_admin/{id}")
	public String updateAdmin(@ModelAttribute("admin") Admin admin, @PathVariable("id") long id) {
		Optional<Admin> existingAdmin = adminService.getAdmin(admin.getAdminId());

	    if (existingAdmin.isPresent()) {
	        // If the admin exists, update its properties
	        Admin updatedAdmin = existingAdmin.get();
	        updatedAdmin.setName(admin.getName());
	        updatedAdmin.setLocation(admin.getLocation());
	        updatedAdmin.setContactNo(admin.getContactNo());
	        updatedAdmin.setEmailId(admin.getEmailId());

	        // Save the updated admin entity
	        adminService.updateAdmin(updatedAdmin);
	        
	        emailService.sendSimpleEmail(
	                updatedAdmin.getEmailId(),
	                "Notification: Admin Information Updated" + "\r\n\r\n" +
	                "Dear " + updatedAdmin.getName() + ",\r\n\r\n"
	                        + "We want to inform you that your admin information has been successfully updated. Please review the changes made:\r\n\r\n"
	                        + "Name: " + updatedAdmin.getName() + "\r\n"
	                        + "Location: " + updatedAdmin.getLocation() + "\r\n"
	                        + "Contact Number: " + updatedAdmin.getContactNo() + "\r\n"
	                        + "Email: " + updatedAdmin.getEmailId() + "\r\n\r\n"
	                        + "Thank you for keeping your information up-to-date.\r\n\r\n"
	                        + "Best regards,\r\n\r\n"
	                        + "BISAG-N Administration Team",
	                        "BISAG ADMINISTRATIVE OFFICE"
	        );
	    }
		return "redirect:/bisag/admin/admin_list";
	}
		
	//---------------------------------- Admin Update Completed ------------------------------------//

	//-------------------------------------- Admin Delete ------------------------------------------//
	
	// Delete Admin
    @PostMapping("/admin_list/delete/{id}")
    public String deleteAdmin(@PathVariable("id") long id) {
        adminService.deleteAdmin(id);
        return "redirect:/bisag/admin/admin_list";
    }
	
	//--------------------------------- Admin Delete Completed -------------------------------------//

	public InternRepo getIrepo() {
		return irepo;
	}

	public void setIrepo(InternRepo irepo) {
		this.irepo = irepo;
	}
	
	//update Intern///////////////////////////////////////////////////
	
	
	//Manage intern application///////////////////////////////////
	
		@GetMapping("/intern_application")
		public ModelAndView internApplication()
		{
			ModelAndView mv = new ModelAndView("admin/intern_application");
			List<InternApplication> interns = internService.getInternApplication();
			mv.addObject("interns",interns);
			return mv;
		}
		@GetMapping("/intern_application/{id}")
		public ModelAndView internApplication(@PathVariable("id") long id)
		{
			System.out.println("id"+id);
			ModelAndView mv = new ModelAndView();
			Optional<InternApplication> intern = internService.getInternApplication(id);
			mv.addObject("intern",intern);
			mv.setViewName("admin/intern_application_detail");
			return mv;
		}
		@PostMapping("/intern_application/ans")
		public String internApplicationSubmission(@RequestParam String message, @RequestParam long id, @RequestParam String status)
		{
			System.out.println("iddd"+id + status);
			//Long ID = Long.parseLong(id);
			Optional<InternApplication> intern = internService.getInternApplication(id);
			intern.get().setStatus(status); 
			
			internService.addInternApplication(intern.get());
			emailService.sendSimpleEmail(intern.get().getEmail(),message, "BISAG INTERNSHIP RESULT");
			return "redirect:/bisag/admin/intern_application";
		}


}
