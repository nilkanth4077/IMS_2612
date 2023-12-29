package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trial.ims.entities.Intern;

@Repository
public interface InternRepo extends JpaRepository<Intern, String> {
	
	Intern findTopByOrderByInternIdDesc();

}
