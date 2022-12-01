package com.tnas.wa.crud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanUtilConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
