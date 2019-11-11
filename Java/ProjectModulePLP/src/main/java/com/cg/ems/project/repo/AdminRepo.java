package com.cg.ems.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.project.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{
	
	
	@Query("SELECT a FROM Admin a WHERE a.adminId=:id AND a.adminPassword=:password")
	Admin loginAdmin(String id, String password) ;

	@Modifying
	@Query("UPDATE Admin a SET a.adminPassword=:newPassword WHERE a.adminId=:id")
	int updatePassword(String id, String newPassword);
}
