package com.trial.ims.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.trial.ims.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
	Admin findTopByOrderByAdminIdDesc();
    
//	@Modifying
//	@Transactional
//	@Query("update Admin a set a.name= :name where a.adminId= :adminId")
//	public void setAdminNameById(@Param(value = "name") String name, @Param(value = "adminId") long adminId);
	
//	@Modifying
//	@Transactional
//	@Query("update Cart c set c.cartPrice= :price where c.cartId= :cartId")
//	public void setPriceById(@Param(value = "price") double price, @Param(value = "cartId") int cartId);
//	
}
