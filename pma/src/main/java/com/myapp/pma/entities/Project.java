package com.myapp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id //id가 기본키다 라는 뜻
	@GeneratedValue(strategy = GenerationType.AUTO) //id를 자동으로 생성할거다 라는 뜻
	private Long projectId;	//프로젝트 ID (카멜케이스 => DB project_id)
	private String name;	//프로젝트 이름
	private String stage;	//프로젝트 상태(시작전, 진행중, 완료)
	private String description;	//설명
	
	//CascadeType.REMOVE CascadeType.PERSIST 제거
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", joinColumns = @JoinColumn(name="project_id"), inverseJoinColumns = @JoinColumn(name="employee_id"))
	private List<Employee> employees; //직원 리스트
	
	
	
	public Project() {
		// 빈 생성자
	}

	public Project(String name, String stage, String description) {
		super();
//		this.projectId = projectId; //프로젝트ID는 DB 자동생성 할 거라 뺐음
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
}
