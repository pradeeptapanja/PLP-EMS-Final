/**
 * 
 */
package com.cg.ems.expense.dto;
/**
 * 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Anurag Kumar
 * @version 1.0
 *
 */
@Entity
@Table(name = "admin_master")
//@NamedQuery(name = "login", query = "SELECT a FROM Admin a WHERE a.adminId=:id AND a.adminPassword=:password")
//@NamedQuery(name = "password", query = "UPDATE Admin a SET a.adminPassword=:newPassword WHERE a.adminId=:id")
public class Admin {

	@Id
	@Column(name = "admin_id")
	@Pattern(regexp = "[AA][0-9]{5}")
	private String adminId;
	
	@Column(name = "admin_name")
	@Pattern(regexp = "[A-Z][a-z]{2,15}")
	@NotBlank
	private String adminName;
	
	@Column(name = "admin_password")
	@Pattern(regexp = "[A-Za-z0-9 _!@#$%&*,./+-]{6,20}")
	@NotBlank
	private String adminPassword;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}