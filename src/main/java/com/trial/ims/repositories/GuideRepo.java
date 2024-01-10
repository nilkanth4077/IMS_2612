package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.ims.entities.Guide;

public interface GuideRepo extends JpaRepository<Guide, Long> {

	Guide findTopByOrderByGuideIdDesc();
	
}
