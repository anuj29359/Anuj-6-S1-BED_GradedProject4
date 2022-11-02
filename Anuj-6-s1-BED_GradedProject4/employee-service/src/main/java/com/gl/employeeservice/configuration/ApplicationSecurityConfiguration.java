package com.gl.employeeservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		System.out.println("In security config class");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("Anuj")
//			.password(passwordEncoder().encode("{noop}welcome"))
				.password("{noop}welcome").roles("Admin").and().withUser("Freddy")
				.password(passwordEncoder().encode("{noop}welcome")).roles("User");
	}

	// Authorization
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// configure authorization rules here
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/employee/**", "/api/v1/users/**")
				.hasAnyRole("USER", "ADMIN").antMatchers("/h2-console/**", "/login/**", "/swagger-ui.html/**")
				.permitAll().and().authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/employee/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/api/v1/employee/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/v1/employee/**").hasRole("ADMIN").anyRequest().authenticated()
				.and().formLogin().and().httpBasic().and()
				/*
				 * Set the sessioncreation policy to avoid using cookies for authentication
				 * https://stackoverflow.com/questions/50842258/spring-security-caching-my-
				 * authentication/50847571
				 */
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/api/v1/users/**");
	}
	
	

}
