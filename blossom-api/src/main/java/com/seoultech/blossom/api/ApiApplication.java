package com.seoultech.blossom.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seoultech.blossom.common.BlossomCommonRoot;
import com.seoultech.blossom.domain.BlossomDomainRoot;
import com.seoultech.blossom.external.BlossomExternalRoot;

@SpringBootApplication(scanBasePackageClasses = {
	BlossomCommonRoot.class,
	BlossomDomainRoot.class,
	BlossomExternalRoot.class,
	ApiApplication.class
})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
