package com.music.school.security;

import com.music.school.audit.AuditorAwareImpl;
import com.music.school.exception.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

@Autowired
private DataSource dataSource;

@Bean
AuditorAware<String> auditorProvider() {
	return new AuditorAwareImpl();
}

//@Override
//public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth
//			.inMemoryAuthentication()
//			.withUser("hamed")
//			.password("{noop}1234")
//			.roles("USER");
//}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
	auth
			.authenticationEventPublisher(authenticationEventPublisher())
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT username,password ,enabled from users where username=?")
			.authoritiesByUsernameQuery("SELECT username,authority_type FROM users join authority on users.id=authority.id where username=?")
			.passwordEncoder(new BCryptPasswordEncoder());
}

@Override
public void configure(HttpSecurity http) throws Exception {
	http
			.antMatcher("/**")
			.authorizeRequests()
			.anyRequest()
			.hasRole("USER")
			.anyRequest()
			.fullyAuthenticated()
			.and()
			.formLogin()
			.loginPage("/login.jsp")
			.failureUrl("/login.jsp?error=1")
			.loginProcessingUrl("/loginProcessingUrl")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/logout.jsp")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	
}

@Bean
public AccessDeniedHandler accessDeniedHandler() {
	return new CustomAccessDeniedHandler();
}

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
}

@Bean
public DefaultAuthenticationEventPublisher authenticationEventPublisher() {
	return new DefaultAuthenticationEventPublisher();
}
}



