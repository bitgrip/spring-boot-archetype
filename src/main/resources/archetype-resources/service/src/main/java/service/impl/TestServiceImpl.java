package ${package}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.service.TestService;
import ${package}.domain.Test;
import ${package}.domain.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;

	public Test helloBitgrip(Test test) {
		return testRepository.save(test);

	}
}
