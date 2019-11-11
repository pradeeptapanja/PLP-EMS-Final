package com.cg.ems.project.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

	@Entity
	@GenericGenerator(name = "project_code_seq", strategy = "increment")
	@Table(name = "project")
	public class Project {

		@Id
		@Column(name = "project_code")
		@GeneratedValue(generator = "project_code_seq", strategy = GenerationType.SEQUENCE)
		private int projectCode;
		
		@Column(name = "project_description")
		@NotBlank(message = "Description is mandatory, cannot be empty")
		private String projectDescription;
		
		@Column(name = "project_startDate")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		//@NotBlank(message = "Start Date is mandatory, cannot be empty")
		private Date startDate;
		
		@Column(name = "project_endDate")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		//@NotBlank(message = "End Date is mandatory, cannot be empty")
		private Date endDate;
		
		@Column(name = "project_businessUnit")
		private String businessUnit;
		
		@Column(name = "project_status")
		private String status;

		public int getProjectCode() {
			return projectCode;
		}

		public void setProjectCode(int projectCode) {
			this.projectCode = projectCode;
		}

		public String getProjectDescription() {
			return projectDescription;
		}

		public void setProjectDescription(String projectDescription) {
			this.projectDescription = projectDescription;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getBusinessUnit() {
			return businessUnit;
		}

		public void setBusinessUnit(String businessUnit) {
			this.businessUnit = businessUnit;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}
