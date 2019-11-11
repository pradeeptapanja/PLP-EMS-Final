/**
 * 
 */
package com.cg.ems.expense.service;

import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.exception.AdminNotFoundException;

/**
 * @author admin
 *
 */
public interface AdminService {

	Admin login(String id, String password) throws AdminNotFoundException;

	//int updatePassword(String id, String oldPassword, String newPassword) throws AdminNotFoundException;
}