package com.cg.ems.project.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.AdminNotFound;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;
import com.cg.ems.project.repo.ProjectRepo;

@Service
@Transactional(rollbackOn = { WrongIDException.class, WrongDurationException.class })
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo repo;

	@Override
	public Project addProject(Project project) throws WrongDurationException {
		Date startDate = project.getStartDate();
		Date endDate = project.getEndDate();
		System.out.println("in service");
		if (endDate.compareTo(startDate) > 0) {
			System.out.println("comparing ratings");
			return repo.save(project);
		} else {
			System.out.println("Exception thrown  ");
			throw new WrongDurationException("Invalid Duration");
		}
	}

	@Override
	public List<Project> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Project searchById(int projectCode) throws WrongIDException {
		try {
			return repo.findById(projectCode).get();
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Project Code " + projectCode + " found");
		}
	}
	@Override
	public Boolean deleteProject(int projectCode) throws WrongIDException {
		try {
			repo.deleteById(projectCode);
			return true;
		} catch (Exception e) {
			throw new WrongIDException("No Project with Project Code " + projectCode + " found");
		}
	}

	@Override
	public int modifyProject(Project project) throws WrongIDException, WrongDurationException {

//		int projectCode = project.getProjectCode();
//		String projectDescription = project.getProjectDescription();
//		Date startDate = project.getStartDate();
//		Date endDate = project.getEndDate();
//		String businessUnit = project.getBusinessUnit();
//		String status = project.getStatus();
		Project pro = null;
		try {
			pro= repo.findById(project.getProjectCode()).get();
			pro.setBusinessUnit(project.getBusinessUnit());
			pro.setEndDate(project.getEndDate());
			pro.setStartDate(project.getStartDate());
			pro.setProjectDescription(project.getProjectDescription());
			pro.setStatus(project.getStatus());

			if (pro.getEndDate().compareTo(pro.getStartDate()) > 0) {
				return repo.save(pro).getProjectCode();
			} else
				throw new WrongDurationException("Invalid Duration");
		} catch (Exception e) {
			throw new WrongIDException("Project with code " + pro.getProjectCode() + " not found");
		}

	}
	
	@Override
	public List<Integer> displayAllId() {
		List<Integer> projId = new ArrayList<Integer>();
		List<Project> displayAll = repo.findAll();

		for (Project proj : displayAll) {
			projId.add(proj.getProjectCode());
			//System.out.println(exp.getExpenseCode());
		}

		return projId;
	}


}