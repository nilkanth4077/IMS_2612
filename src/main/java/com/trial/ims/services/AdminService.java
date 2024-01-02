package com.trial.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.trial.ims.entities.Admin;
import com.trial.ims.repositories.AdminListRepo;
import com.trial.ims.repositories.AdminRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminListRepo adminlistRepo;
	
	public void registerAdmin(Admin admin)
	{
		adminRepo.save(admin);
	}

	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}
	
	public Optional<Admin> getAdmin(long id) {
		// TODO Auto-generated method stub
//		return AdminListRepo.findById(id);
		return adminlistRepo.findById(id);
	}

	public void deleteAdmin(long id) {
		// TODO Auto-generated method stub
		adminRepo.deleteById(id);
	}

	public void updateAdmin(Admin updatedAdmin) {
		// TODO Auto-generated method stub
		adminRepo.save(updatedAdmin);
	}
	

    // Update Admin
//	public void updateAdmin(Admin admin) {
//        // Check if the admin with the given ID exists
////        adminRepo.setAdminNameById(admin.getName(),admin.getAdminId());
//		
//		Optional<Admin> existingAdmin = adminRepo.findById(admin.getAdminId());
//
//        if (existingAdmin.isPresent()) {
//            // If the admin exists, update its properties
//            Admin updatedAdmin = existingAdmin.get();
//            updatedAdmin.setName(admin.getName());
//            // Update other properties as needed
//
//            // Save the updated admin entity
//            adminRepo.save(updatedAdmin);
//        }
//    }
	
}
