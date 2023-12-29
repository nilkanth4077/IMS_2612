package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trial.ims.entities.Admin;
import com.trial.ims.entities.InternApplication;

@Repository
public interface AdminListRepo extends JpaRepository<Admin, Long> {
	
}