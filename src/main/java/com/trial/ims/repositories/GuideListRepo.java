package com.trial.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.ims.entities.Guide;

public interface GuideListRepo extends JpaRepository<Guide, Long> {

}
