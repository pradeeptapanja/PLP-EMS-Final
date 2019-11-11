/**
 * 
 */
package com.cg.ems.expense.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.exception.AdminNotFoundException;
import com.cg.ems.expense.repo.AdminRepo;

/**
 * @author admin
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo aRepo;

	/**
	 * 
	 */
	@Override
	public Admin login(String id, String password) throws AdminNotFoundException {
		Admin admin = aRepo.loginAdmin(id, password);
		if (admin != null)
			return admin;
		else
			throw new AdminNotFoundException("Wrong credentials");
	}

//	@Override
//	public int updatePassword(String id, String oldPassword, String newPassword) throws AdminNotFoundException {
//
//		Admin admin = aRepo.loginAdmin(id, oldPassword);
//		if (admin != null)
//			return aRepo.updatePassword(id, newPassword);
//		else
//			throw new AdminNotFoundException("Wrong credentials");
//	}
}
