package com.seoultech.blossom.domain.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.seoultech.blossom.domain.BlossomDomainRoot;

@Configuration
@EntityScan(basePackageClasses = {BlossomDomainRoot.class})
@EnableJpaRepositories(basePackageClasses = {BlossomDomainRoot.class})
@EnableJpaAuditing
public class JpaConfig {

}
