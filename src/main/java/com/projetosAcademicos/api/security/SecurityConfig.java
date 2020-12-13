package com.projetosAcademicos.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
				.httpBasic().and().csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		
		auth.inMemoryAuthentication().passwordEncoder(passEncoder)
			.withUser("professor").password(passEncoder.encode("professor")).roles("PROFESSOR").and()
		  	.withUser("aluno").password(passEncoder.encode("aluno")).roles("ALUNO");
	}
	
}
