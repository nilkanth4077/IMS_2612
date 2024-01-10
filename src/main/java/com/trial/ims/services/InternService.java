package com.trial.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trial.ims.entities.Intern;
import com.trial.ims.entities.InternApplication;
import com.trial.ims.repositories.InternApplicationRepo;
import com.trial.ims.repositories.InternRepo;

@Service
public class InternService {
	
//	@Autowired
//	private InternRepo repo;
//	public void registerIntern(Intern intern)
//	{
//		repo.save(intern);
//	}
//	
//	public String getMostRecentInternId()
//	{
//		Intern mostRecentIntern = repo.findTopByOrderByInternIdDesc();
//        return mostRecentIntern != null ? mostRecentIntern.getInternId() : null;
//	}
	
	
	@Autowired
	private InternRepo internRepo;
	@Autowired
	private InternApplicationRepo internApplicationRepo;
	
	public void registerIntern(Intern intern)
	{
		internRepo.save(intern);
	}
	
	public String getMostRecentInternId()
	{
		Intern mostRecentIntern = internRepo.findTopByOrderByInternIdDesc();
        return mostRecentIntern != null ? mostRecentIntern.getInternId() : null;
	}
	public List<InternApplication> getInternApplication()
	{
		return internApplicationRepo.findAll();
	}
	public Optional<InternApplication> getInternApplication(long id)
	{
		return internApplicationRepo.findById(id);
	}
	public void addInternApplication(InternApplication intern)
	{
		internApplicationRepo.save(intern);
	}



}
