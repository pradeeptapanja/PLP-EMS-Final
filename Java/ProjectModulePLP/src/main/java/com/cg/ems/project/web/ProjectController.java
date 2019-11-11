package com.cg.ems.project.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.project.dto.Admin;
import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.AdminNotFound;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;
import com.cg.ems.project.service.AdminService;
import com.cg.ems.project.service.ProjectService;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4201","http://localhost:4206","http://localhost:4615","http://localhost:4620","http://localhost:4205","http://localhost:4202"})
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	@Autowired
	private AdminService adminService;

	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Project addNewProject(@RequestBody Project project) throws WrongDurationException {
		System.out.println("in controller");
		return service.addProject(project);
		
	}

	@GetMapping(produces = "application/json")
	public List<Project> getAllProjects() {
		return service.fetchAll();
	}

	@GetMapping(value = "/projectCode/{projectCode}", produces = "application/json")
	public Project searchByProjectCode(@PathVariable String projectCode) throws WrongIDException{
		return service.searchById(Integer.parseInt(projectCode));
	}
	

	@DeleteMapping(value = "/delete/{projectCode}", produces = "application/json")
	public boolean removeByprojectCode(@PathVariable int projectCode) throws WrongIDException {
		return service.deleteProject(projectCode);
	}
	
	@PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public int updateProject(@RequestBody Project project) throws WrongIDException, WrongDurationException {
		int temp = service.modifyProject(project);
		if (temp > 0)
			return temp;
		else 
			return -1;
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public Admin loginAdmin(@RequestParam("id") String id, @RequestParam("password") String password){
		//logger.info("Trying for Login");
		try {
			//logger.info("Successful Employee login");
			return adminService.login(id, password);
		} catch (AdminNotFound ex) {
			//logger.error("Employees login not successful ");
			System.out.println(ex.getMessage());
			return null;
		}
	
	}
	@GetMapping(value = "/allId", produces = "application/json")
	public List<Integer> getAllExpensesId() {
		List<Integer> ids =  service.displayAllId();
		
		return ids;
	}
	
	
	/*@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee loginEmployee(@RequestParam String empId, @RequestParam String password)   {
		logger.info("Trying for Login");
		try {
			logger.info("Successful Employee login");
			return service.loginEmployee(empId, password);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees login not successful ");
			System.out.println(ex.getMessage());
			return null;
		}
	}*/
	
	
}