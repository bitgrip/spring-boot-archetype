package ${package}.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Type;
import java.net.URI;
import java.security.Principal;
import java.util.*;

/**
 * <p>Central Swagger configuration using configurationProperties @see {@link SwaggerConfigurationProperties}</p>
 * <p>
 * (w) marcelmuller<br/>
 * (c) bitgrip GmbH, 2019
 * </p>
 */
@Configuration
@EnableConfigurationProperties(SwaggerConfigurationProperties.class)
public class SwaggerConfig {

  public static final String SWAGGER_DEFAULT_PATH = "/v2/api-docs";

  private SwaggerConfigurationProperties swaggerConfigurationProperties;

  private TypeResolver typeResolver;

  public SwaggerConfig(SwaggerConfigurationProperties swaggerConfigurationProperties, TypeResolver typeResolver) {
    this.swaggerConfigurationProperties = swaggerConfigurationProperties;
    this.typeResolver = typeResolver;
  }

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .ignoredParameterTypes(Principal.class)
            .select()
            .apis(RequestHandlerSelectors.basePackage(swaggerConfigurationProperties.getBasePackage()))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
            .title(swaggerConfigurationProperties.getApiInfo().getTitle())
            .description(swaggerConfigurationProperties.getApiInfo().getDescription())
            .version(swaggerConfigurationProperties.getApiInfo().getVersion())
            .contact(swaggerConfigurationProperties.getApiInfo().getContact().toContact())
            .build();
  }

  @Bean
  public AlternateTypeRuleConvention pageableConvention(
          final TypeResolver resolver) {
    return new AlternateTypeRuleConvention() {

      @Override
      public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
      }

      @Override
      public List<AlternateTypeRule> rules() {
        return Arrays.asList(
                AlternateTypeRules.newRule(resolver.resolve(Pageable.class), resolver.resolve(pageableMixin())),
                AlternateTypeRules.newRule(resolver.resolve(URI.class), resolver.resolve(String.class))
        );
      }
    };
  }


  private Type pageableMixin() {
    return new AlternateTypeBuilder()
            .fullyQualifiedClassName(
                    String.format("%s.generated.%s",
                            Pageable.class.getPackage().getName(),
                            Pageable.class.getSimpleName()))
            .withProperties(Arrays.asList(
                    property(Integer.class, "page"),
                    property(Integer.class, "size"),
                    property(String.class, "sort")
            ))
            .build();
  }

  private AlternateTypePropertyBuilder property(Class<?> type, String name) {
    return new AlternateTypePropertyBuilder()
            .withName(name)
            .withType(type)
            .withCanRead(true)
            .withCanWrite(true);
  }
}
