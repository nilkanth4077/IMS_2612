package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.ims.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {
	Admin findTopByOrderByAdminIdDesc();
}
