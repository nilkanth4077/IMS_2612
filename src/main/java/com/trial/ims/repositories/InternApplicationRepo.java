package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trial.ims.entities.InternApplication;

@Repository
public interface InternApplicationRepo extends JpaRepository<InternApplication, Long> {
	
}