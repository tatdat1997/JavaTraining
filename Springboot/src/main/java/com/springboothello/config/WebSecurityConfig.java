package com.springboothello.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboothello.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	/**
	 * configure security set up link for role
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		.authorizeRequests()
		.antMatchers("/register", "/registerUser", "/login", "/checkLogin", "/").permitAll()
		.antMatchers("/search","/listStudent/page/{pageNumber}", "/api/search",
				"/api/search/page/{page}","/logout").hasAnyRole("ADMIN","MEMBER")
		.antMatchers("/newStudent", "/deleteStudent/id/{id}", "/infoStudent/id/{id}", 
				"/newStudent","/saveStudent", "/updateStudent/id/{id}").hasRole("ADMIN")
		.antMatchers("/*").authenticated()
		.and()
		.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password")
			.defaultSuccessUrl("/checkLogin").permitAll() // Sẽ chạy sang GET
			.failureUrl("/checkLogin")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and()
		.exceptionHandling().accessDeniedPage("/error")
		.and()
		.csrf().ignoringAntMatchers("/api/search");

	}

}
