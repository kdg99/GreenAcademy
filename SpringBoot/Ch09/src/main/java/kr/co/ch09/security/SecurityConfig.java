package kr.co.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//접근권한 설정
		http.authorizeRequests().antMatchers("/").permitAll();

		//사이트 위조 방지 설정
		http.csrf().disable();
		
		/*
		//로그인 설정
		http.formLogin()
		.loginPage("/user2/login")
		.defaultSuccessUrl("/user2/loginSuccess")
		.usernameParameter("uid")
		.passwordParameter("pass");
		
		//로그아웃 설정
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
		.logoutSuccessUrl("/user2/login");
		*/
	}
	
	@Autowired
	//private User2Service service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//사용자 권한 설정
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		
		//로그인 인증 처리 서비스, 암호화 방식 설정
		//auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

}
