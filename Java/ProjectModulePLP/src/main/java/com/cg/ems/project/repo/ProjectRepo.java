package com.cg.ems.project.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.dto.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project ,Integer>{

	@Modifying
	@Query("UPDATE Project p SET p.projectDescription=:pD, p.startDate=:sD, p.endDate=:eD, p.businessUnit=:pB, p.status=:pS WHERE p.projectCode=:pC")
	int modifyProject(String pD, Date sD, Date eD, String pB, String pS,int pC); 

	//@Query("SELECT a FROM Admin a WHERE a.adminId=:id AND a.adminPassword=:password ")
	//Admin loginAdmin(String id, String password) ;


}