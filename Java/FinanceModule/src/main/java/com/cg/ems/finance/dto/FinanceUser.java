/**
 * 
 */
package com.cg.ems.finance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Panja
 * @version 1.0
 */

@Entity
@Table(name = "finance_user")

public class FinanceUser {

	@Id
	@Column(name = "finance_user_id")
	private String financeUserId;

	@Column(name = "finance_user_name")
	@NotNull
	private String financeUserName;

	@Column(name = "finance_user_password")
	@NotNull
	private String financeUserPassword;

	@Column(name = "finance_user_email")
	@NotNull
	private String financeUserEMail;

	@Column(name = "finance_user_mobile")
	@NotNull
	private String financeUserMobile;

	/**
	 * @return the financeUserId
	 */
	public String getFinanceUserId() {
		return financeUserId;
	}

	/**
	 * @param financeUserId the financeUserId to set
	 */
	public void setFinanceUserId(String financeId) {
		this.financeUserId = financeId;
	}

	/**
	 * @return the financeUserName
	 */
	public String getFinanceUserName() {
		return financeUserName;
	}

	/**
	 * @param financeUserName the financeUserName to set
	 */
	public void setFinanceUserName(String financeUserName) {
		this.financeUserName = financeUserName;
	}

	/**
	 * @return the financeUserPassword
	 */
	public String getFinanceUserPassword() {
		return financeUserPassword;
	}

	/**
	 * @param financeUserPassword the financeUserPassword to set
	 */
	public void setFinanceUserPassword(String financeUserPassword) {
		this.financeUserPassword = financeUserPassword;
	}

	/**
	 * @return the financeUserEMail
	 */
	public String getFinanceUserEMail() {
		return financeUserEMail;
	}

	/**
	 * @param financeUserEMail the financeUserEMail to set
	 */
	public void setFinanceUserEMail(String financeUserEMail) {
		this.financeUserEMail = financeUserEMail;
	}

	/**
	 * @return the financeUserMobile
	 */
	public String getFinanceUserMobile() {
		return financeUserMobile;
	}

	/**
	 * @param financeUserMobile the financeUserMobile to set
	 */
	public void setFinanceUserMobile(String financeUserMobile) {
		this.financeUserMobile = financeUserMobile;
	}

	/**
	 * default constructor
	 */
	public FinanceUser() {
		// TODO Auto-generated constructor stub
	}

}
