package com.seoultech.blossom.api.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.seoultech.blossom.common.constant.ProfileType;

@Configuration
public class FilterConfig {

	@Profile({ProfileType.DEV, ProfileType.PROD})
	@Bean
	public FilterRegistrationBean<RequestLoggingFilter> requestLoggingFilter() {
		FilterRegistrationBean<RequestLoggingFilter> filter = new FilterRegistrationBean<>(new RequestLoggingFilter());
		filter.addUrlPatterns("/api/*");
		filter.setOrder(1);
		return filter;
	}

}
