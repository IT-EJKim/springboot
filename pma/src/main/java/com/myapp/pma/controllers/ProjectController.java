package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	// 스프링에서 오토와이어는 관련 객체를 필요할 때 자동으로 연결해준다.
	// 스프링에서 repository 객체를 처음에 자동생성해서 가지고 있다가 autowired가 있으면 자동으로 연결.
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping
	public String displayProjectList(Model model) {
		List<Project> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		return "projectList";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project p = new Project();
		model.addAttribute("project",p);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project) {
		projectRepository.save(project); //DB에 project객체를 테이블에 저장
		return "redirect:/projects/new"; //post-redirect-get 패턴
	}
}