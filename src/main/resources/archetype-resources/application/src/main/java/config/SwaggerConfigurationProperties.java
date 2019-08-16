package ${package}.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.Contact;

/**
 * <p>Configuration Properties for configure springfox swagger</p>
 * <p>
 * (w) marcelmuller<br/>
 * (c) bitgrip GmbH, 2019
 * </p>
 */
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfigurationProperties {

  private String basePackage;

  private ApiInfo apiInfo;

  public String getBasePackage() {
    return basePackage;
  }

  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }

  public ApiInfo getApiInfo() {
    return apiInfo;
  }

  public void setApiInfo(ApiInfo apiInfo) {
    this.apiInfo = apiInfo;
  }

  public static class ApiInfo {

    private String title;

    private String description;

    private String version;

    private SwaggerContact contact;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public SwaggerContact getContact() {
      return contact;
    }

    public void setContact(SwaggerContact contact) {
      this.contact = contact;
    }

    public static class SwaggerContact {

      private String name;

      private String url;

      private String email;


      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public String getEmail() {
        return email;
      }

      public void setEmail(String email) {
        this.email = email;
      }

      /**
       * Method which creates a Swagger Contact Object @see {@link Contact}
       *
       * @return fresh created @see {@link Contact} object for Swagger Configuration
       */
      public Contact toContact() {
        return new Contact(name, url, email);
      }
    }
  }
}
