package com.tnas.wa.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tnas.wa.crud.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("WA CRUD Case API")
                .description("API Documentation for WA CRUD Case")
                .version("1.0.0")
                .build();
    }	
}
