package com.webosmotic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		
		User.withUsername("user").password(passwordEncoder().encode("system")).roles("GETALL").build();
		
		User.withUsername("user1").password(passwordEncoder().encode("system1")).roles("GETUSERBYID").build();
		
		User.withUsername("user2").password(passwordEncoder().encode("system2")).roles("DELETEUSER").build();
		
		User.withUsername("user3").password(passwordEncoder().encode("system3")).roles("UPDATEUSER").build();
		
		User.withUsername("user4").password(passwordEncoder().encode("system4")).roles("CREATEUSER").build();
		
		return userDetailService();
		
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf()
		.disable()
		.authorizeRequests()
		.requestMatchers()
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
		
		
	}

}
