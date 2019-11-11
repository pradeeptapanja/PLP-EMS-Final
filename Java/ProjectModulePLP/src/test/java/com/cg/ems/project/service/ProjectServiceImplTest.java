package com.cg.ems.project.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {
	
	@Autowired
	private ProjectService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testAddProject() throws WrongDurationException, WrongIDException {
		Project p = new Project();
		p.setProjectCode(1);
		p.setBusinessUnit("asdjasgbu");
		p.setEndDate(Date.valueOf(LocalDate.parse("2019-12-02")));
		//p.setProjectCode("86543");
		p.setProjectDescription("asfdasfasfasfd");
		
		p.setStartDate(Date.valueOf(LocalDate.parse("2019-11-30")));
		p.setStatus("Completed");
		
		Project pro = service.addProject(p);
		System.out.println(pro.getProjectCode());
		
	}
	
	@Test
	public void testDisplayAllProject() {
		assertNotNull(service.fetchAll());
	}

	@Test
	public void testDisplayAllProjectFail() {
		assertNull(service.fetchAll()); // only if table is empty
	}
	@Test
	public void testDeleteProject() throws WrongIDException {
		boolean b = service.deleteProject(10);
	}
	
	@Test(expected = WrongIDException.class)
	public void testDeleteProjectFail() throws WrongIDException {
		boolean b = service.deleteProject(2);
		assertEquals(true, b); 
	}



}
