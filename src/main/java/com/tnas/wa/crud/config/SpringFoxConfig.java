package com.tnas.wa.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;
import com.tnas.wa.crud.api.UserParam;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api(TypeResolver typeResolver) {
		return new Docket(DocumentationType.SWAGGER_2)
				.additionalModels(typeResolver.resolve(UserParam.class))
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
