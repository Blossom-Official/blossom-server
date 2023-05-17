package com.seoultech.blossom.api.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
public class HealthController {

	@GetMapping("/health")
	public String checkHealth() {
		return "healthy";
	}
}
