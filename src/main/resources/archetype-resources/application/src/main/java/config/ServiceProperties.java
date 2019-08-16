package ${package}.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="my.service")
public class ServiceProperties {

	private String myProperty;

	public String getMyProperty() {
		return this.myProperty;
	}

	public void setMyProperty(String myProperty) {
		this.myProperty=myProperty;
	}

}
