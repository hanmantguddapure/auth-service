package com.auth.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth.service.oauth.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	public WebSecurityConfig(CustomOAuth2UserService customOAuth2UserService) {

		this.customOAuth2UserService = customOAuth2UserService;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/", "/error").permitAll()
				.antMatchers("/auth/**").permitAll().anyRequest().authenticated().and().oauth2Login()
				.authorizationEndpoint().and().userInfoEndpoint().userService(customOAuth2UserService);
	}
}
