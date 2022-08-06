package com.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "sucess";
	}

	@GetMapping("/social-login")
	public String socialLogin() {
		return "social login sucess";
	}
}
