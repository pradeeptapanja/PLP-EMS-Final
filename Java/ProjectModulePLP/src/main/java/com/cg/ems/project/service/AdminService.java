package com.cg.ems.project.service;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.exception.AdminNotFound;

public interface AdminService {
	

	Admin login(String id,String password) throws AdminNotFound;
	
	int updatePassword(String id, String oldpassword, String newPassword);
	
}
