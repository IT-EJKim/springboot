package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	// 스프링에서 오토와이어는 관련 객체를 필요할 때 자동으로 연결해준다.
	// 스프링에서 repository 객체를 처음에 자동생성해서 가지고 있다가 autowired가 있으면 자동으로 연결.
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping
	public String displayProjectList(Model model) {
		List<Project> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project p = new Project(); // 빈 생성자 사용
		model.addAttribute("project",p);
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute("employeeList", employeeList);
		return "projects/new-project"; //new-project.html 랜더링
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees) {
		projectRepository.save(project); //DB에 project객체를 테이블에 저장
		Iterable<Employee> selectEmployees = employeeRepo.findAllById(employees);
		for(Employee emp : selectEmployees) {
			emp.setProject(project);
			employeeRepo.save(emp);
		}
		return "redirect:/projects/new"; //post-redirect-get 패턴
	}
}
