package com.trial.ims.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trial.ims.entities.Guide;
import com.trial.ims.repositories.GuideRepo;
import com.trial.ims.services.EmailSenderService;
import com.trial.ims.services.GuideService;

@Controller
@RequestMapping("/bisag/admin")
public class GuideController {
	
	@Autowired
	private GuideService guideService;
	
	private EmailSenderService emailService;
	
	
	public GuideController(GuideRepo grepo, EmailSenderService emailService) {
		// TODO Auto-generated constructor stub
		this.emailService = emailService;
	}

	//----------------------------------- Guide registration ---------------------------------------//
	
		@GetMapping("/register_guide")
		public String registerGuide()
		{
			return "admin/guide_registration";
		}
		
		@PostMapping("/register_guide")
		public String registerGuide(@ModelAttribute("guide") Guide guide)
		{
			guideService.registerGuide(guide);
			emailService.sendSimpleEmail(
					guide.getEmailId(),
					"Notification: Appointment as Administrator\r\n"
					+ "\r\n"
					+ "Dear " + guide.getName() + "\r\n"
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
			
			return "redirect:/bisag/admin/guide_list";
		}
		
		
		
		
		//--------------------------------------- Guide List -------------------------------------------//
		
		@GetMapping("/guide_list")
		public ModelAndView guideList()
		{
			ModelAndView mv = new ModelAndView("admin/guide_list");
			List<Guide> guides = guideService.getGuide();
			mv.addObject("guides", guides);
			return mv;
		}
		@GetMapping("/guide_list/{id}")
		public ModelAndView guideList(@PathVariable("id") long id)
		{
			System.out.println("id"+id);
			ModelAndView mv = new ModelAndView();
			Optional<Guide> guide = guideService.getGuide(id);
			mv.addObject("guide",guide);
			mv.setViewName("admin/guide_list_detail");
			return mv;
		}
		
		@PostMapping("/guide_list/ans")
		public String guideListRedirect()
		{
			System.out.println("iddd");
			
			return "redirect:/bisag/admin/guide_list";
		}
		
		//-------------------------------------- Guide Update ------------------------------------------//
		
		@GetMapping("/update_guide/{id}")
		public ModelAndView updateGuide(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("admin/update_guide");
			Optional<Guide> guide = guideService.getGuide(id);
			mv.addObject("guide", guide.orElse(new Guide()));
//			adminService.deleteAdmin(id);
			return mv;
		}
		
		@PostMapping("/update_guide/{id}")
		public String updateGuide(@ModelAttribute("guide") Guide guide, @PathVariable("id") long id) {
			Optional<Guide> existingGuide = guideService.getGuide(guide.getGuideId());

		    if (existingGuide.isPresent()) {
		        // If the admin exists, update its properties
		        Guide updatedGuide = existingGuide.get();
		        updatedGuide.setName(guide.getName());
		        updatedGuide.setLocation(guide.getLocation());
		        updatedGuide.setFloor(guide.getFloor());
		        updatedGuide.setLabNo(guide.getLabNo());
		        updatedGuide.setContactNo(guide.getContactNo());
		        updatedGuide.setEmailId(guide.getEmailId());

		        // Save the updated guide entity
		        guideService.updateGuide(updatedGuide);
		        
		     // Send email notification for the guide's update
		        emailService.sendSimpleEmail(
		                updatedGuide.getEmailId(),
		                "Notification: Guide Information Updated" + "\r\n\r\n" +
		                "Dear " + updatedGuide.getName() + ",\r\n\r\n"
		                        + "We want to inform you that your guide information has been successfully updated. Please review the changes made:\r\n\r\n"
		                        + "Name: " + updatedGuide.getName() + "\r\n"
		                        + "Location: " + updatedGuide.getLocation() + "\r\n"
		                        + "Floor: " + updatedGuide.getFloor() + "\r\n"
		                        + "Lab Number: " + updatedGuide.getLabNo() + "\r\n"
		                        + "Contact Number: " + updatedGuide.getContactNo() + "\r\n"
		                        + "Email: " + updatedGuide.getEmailId() + "\r\n\r\n"
		                        + "Thank you for keeping your information up-to-date.\r\n\r\n"
		                        + "Best regards,\r\n\r\n"
		                        + "BISAG-N Administration Team",
		                        "BISAG ADMINISTRATIVE OFFICE"
		        );


		    }
			return "redirect:/bisag/admin/guide_list";
		}
			
		//---------------------------------- Guide Update Completed ------------------------------------//
		
		//---------------------------------- Guide List Completed --------------------------------------//
	
		// Delete Guide
	    @PostMapping("/guide_list/delete/{id}")
	    public String deleteAdmin(@PathVariable("id") long id) {
	        guideService.deleteGuide(id);
	        return "redirect:/bisag/admin/guide_list";
	    }
}
