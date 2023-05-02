package com.seoultech.blossom.api.config.swagger;

import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seoultech.blossom.api.config.resolver.UserId;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components().addSecuritySchemes("Authorization", new SecurityScheme()
				.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
				.in(SecurityScheme.In.HEADER).name("Authorization")))
			.info(new Info()
				.title("Blossom API Server")
				.description("Blossom API Docs"));
	}

	static {
		SpringDocUtils.getConfig().addAnnotationsToIgnore(UserId.class);
	}

}
