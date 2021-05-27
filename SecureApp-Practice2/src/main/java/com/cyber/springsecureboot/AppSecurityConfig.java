package com.cyber.springsecureboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	/*
	 * @Override
	 * 
	 * @Bean protected UserDetailsService userDetailsService() { // TODO
	 * Auto-generated method stub
	 * 
	 * List<UserDetails> user = new ArrayList<>();
	 * 
	 * user.add(User.withDefaultPasswordEncoder().username("Rajiv").password("1234")
	 * .roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
	
	@Autowired
	UserDetailsService userdetails;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userdetails);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		
		return provider;
		
	}
	

}
