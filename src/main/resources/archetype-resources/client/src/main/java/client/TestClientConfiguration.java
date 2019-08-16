package ${package}.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Operation service client configuration</p>
 * <p>
 * (w) marcelmuller<br/>
 * (c) bitgrip GmbH, 2019
 * </p>
 */
@Configuration
@EnableFeignClients(clients = { TestClient.class })
public class TestClientConfiguration {

  public static final String TEST_CLIENT_URL = "${api.test.url}";

}
