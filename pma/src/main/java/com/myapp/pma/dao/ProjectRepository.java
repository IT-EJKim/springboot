package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Project;

//JPA에서는 리파지토리에 CRUD 가능한 인터페이스 CrudRepository를 상속

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	// CrudRepository에 이미 CRUD 코드가 다 만들어져 있음. => JPA 하이버네이트가 구현 코드도 다 자동 생성
	@Override
	List<Project> findAll(); // 기존의 findAll()의 리턴타입이 Iterable<Project> 라서 수정함.

}
