package com.trial.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trial.ims.entities.Admin;
import com.trial.ims.repositories.AdminListRepo;
import com.trial.ims.repositories.AdminRepo;

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
	
}
