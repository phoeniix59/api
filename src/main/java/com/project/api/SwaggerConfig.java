package com.project.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@EnableSwagger2
@Configuration
@Profile("!test")
public class SwaggerConfig {

    private static final Set<String> JSON_MEDIA_TYPE = Collections.singleton(MediaType.APPLICATION_JSON_VALUE);

//    private final BuildInfoProperties buildInfoProperties;

//    public SwaggerConfig(BuildInfoProperties buildInfoProperties) {
//        this.buildInfoProperties = buildInfoProperties;
//    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(JSON_MEDIA_TYPE)
                .produces(JSON_MEDIA_TYPE)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, messagesForGetMethod())
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.project.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private List<ResponseMessage> messagesForGetMethod() {
        return List.of(
                new ResponseMessageBuilder()
                        .code(200).message("Everything is fine")
                        .responseModel(new ModelRef("OK"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(404).message("Not Found")
                        .build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .build()
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Holiday API")
                .description("Property API")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .version("0")
                .build();
    }

}
