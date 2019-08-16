package ${package}.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import ${package}.api.dto.request.HelloWorldRequestDTO;
import ${package}.api.dto.response.HelloWorldResponseDTO;


@RequestMapping(value = "/test")
public interface TestController {


	@ApiOperation(
            notes = "Magic happens",
            value = "create Message by HelloWorldRequestDTO"
    )
	@PostMapping
	public  HelloWorldResponseDTO helloBitgrip( @ApiParam(value = "HelloWorldRequestDTO") HelloWorldRequestDTO request);

}
