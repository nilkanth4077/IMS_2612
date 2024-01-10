package com.trial.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trial.ims.entities.Guide;
import com.trial.ims.repositories.GuideListRepo;
import com.trial.ims.repositories.GuideRepo;

@Service
public class GuideService {

	@Autowired
	private GuideRepo guideRepo;
	@Autowired
	private GuideListRepo guidelistRepo;
	
	public void registerGuide(Guide guide)
	{
		guideRepo.save(guide);
	}

	public List<Guide> getGuide() {
		// TODO Auto-generated method stub
		return guideRepo.findAll();
	}
	
	public Optional<Guide> getGuide(long id) {
		// TODO Auto-generated method stub
//		return AdminListRepo.findById(id);
		return guidelistRepo.findById(id);
	}
	
	public void updateGuide(Guide updatedGuide) {
		// TODO Auto-generated method stub
		guideRepo.save(updatedGuide);
	}

	public void deleteGuide(long id) {
		// TODO Auto-generated method stub
		guideRepo.deleteById(id);
	}
	
}
