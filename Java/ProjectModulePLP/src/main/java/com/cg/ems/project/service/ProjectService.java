package com.cg.ems.project.service;

import java.sql.Date;
import java.util.List;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.AdminNotFound;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;

public interface ProjectService {

	Project addProject(Project project) throws WrongDurationException;
	
	
	List<Project> fetchAll();
	
	//Project searchById(int projectCode) throws WrongIDException;
	
	Boolean deleteProject(int projectCode) throws WrongIDException;

	//int modifyProject(int projectCode, String projectDescription, Date startDate, Date endDate, String businessUnit,
		//	String status) throws WrongIDException;


	int modifyProject(Project project) throws WrongIDException, WrongDurationException;


	Project searchById(int projectCode) throws WrongIDException;

	List<Integer> displayAllId();
	

}