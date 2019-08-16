package ${package}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceConfiguration {


}
