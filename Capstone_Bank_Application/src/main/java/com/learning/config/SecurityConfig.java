//package com.learning.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter  
//{
//
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//	
//	//Authorization
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//here we are giving the authorization tho the 
//		//following user as an admin 
//		// auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
//		auth.userDetailsService(userDetailsService);
//		
//	}
//	//in order to override spring generated login page and used customerized
//	//or our own login page 
//	
//	//authorization
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//			.antMatchers("/api/customer/**").hasAuthority("USER")
//			.antMatchers("/api/staff/**").hasAuthority("STAFF")
//			.antMatchers("/api/customer/home").permitAll() //pretty much no use (because .antMatchers("/api/customer/**").hasAuthority("USER"))
//			.and().formLogin();
//		
//		http.csrf().disable(); //for post mapping 
//	}
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//}