package ${package}.controller.mapper;


import org.mapstruct.Mapper;

import ${package}.domain.Test;
import ${package}.api.dto.request.HelloWorldRequestDTO;
import ${package}.api.dto.response.HelloWorldResponseDTO;

@Mapper(componentModel="spring")
public interface TestMapper {


	HelloWorldResponseDTO toHelloWorldResponseDTO(Test test);

	Test toTest(HelloWorldRequestDTO request);
}
