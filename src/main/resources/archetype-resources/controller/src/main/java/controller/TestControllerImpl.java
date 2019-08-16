package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ${package}.controller.mapper.TestMapper;
import ${package}.api.dto.request.HelloWorldRequestDTO;
import ${package}.domain.Test;
import ${package}.api.dto.response.HelloWorldResponseDTO;
import ${package}.api.TestController;
import ${package}.service.TestService;


@RestController
public class TestControllerImpl implements TestController{

	@Autowired
	private TestService testService;

	@Autowired
	private TestMapper testMapper;


	public  HelloWorldResponseDTO helloBitgrip(@RequestBody HelloWorldRequestDTO request) {
		Test result = testService.helloBitgrip(testMapper.toTest(request));
		return testMapper.toHelloWorldResponseDTO(result);
	}
}
