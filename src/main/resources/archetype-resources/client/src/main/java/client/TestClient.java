package ${package}.client;


import org.springframework.cloud.openfeign.FeignClient;
import ${package}.api.TestController;

@FeignClient(name = "test", url = TestClientConfiguration.TEST_CLIENT_URL)
public interface TestClient extends TestController {

}
