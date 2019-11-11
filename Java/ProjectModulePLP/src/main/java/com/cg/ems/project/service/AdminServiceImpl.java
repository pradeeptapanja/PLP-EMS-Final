package com.cg.ems.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.exception.AdminNotFound;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;
import com.cg.ems.project.repo.AdminRepo;
import com.cg.ems.project.repo.ProjectRepo;
@Service
@Transactional(rollbackOn = { AdminNotFound.class, WrongDurationException.class })

public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepo repo;

	
	public AdminServiceImpl() {
	}

	@Override
	public Admin login(String id, String password) throws AdminNotFound {
		Admin admin = repo.loginAdmin(id, password);
		if (admin != null) 
		{
			System.out.println("printed");
			return admin;
		} else
			throw new AdminNotFound("Wrong input feeded");
	}
	
	@Override
	public int updatePassword(String id, String oldPassword, String newPassword) {
		Admin admin = repo.loginAdmin(id, oldPassword);
		if (admin != null)
			return repo.updatePassword(id, newPassword);
		else
			return 0;
	}

}
