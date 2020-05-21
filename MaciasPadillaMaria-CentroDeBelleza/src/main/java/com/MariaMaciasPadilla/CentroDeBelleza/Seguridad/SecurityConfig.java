package com.MariaMaciasPadilla.CentroDeBelleza.Seguridad;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsService userDetailsService;
	private final CustomSuccessHandler customSuccessHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		
		http
		.authorizeRequests()
		.antMatchers("/css/**","/js/**", "/img/**","/files/**", "/h2-console/**", "/detalles","/index", "/cookies", "/privacidad", "/registroCliente").permitAll()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("USER")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			//.defaultSuccessUrl("/index")
			.successHandler(customSuccessHandler)
			.and()
		.logout()
			.logoutUrl("/logout")
			.permitAll()
			.and()
		.exceptionHandling()
			.accessDeniedPage("/acceso-denegado");
			//.and()
			//.rememberMe().tokenRepository(persistentTokenRepository())
			//.tokenValiditySeconds(1209600);
		//.rememberMe()
			//.tokenValiditySeconds(3600)
		//	.key("admin") intento de recordar contraseña
	
		// Añadimos esto para poder seguir accediendo a la consola de H2
		// con Spring Security habilitado.
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		// @formatter:on
		
		/* Intento de recordar contraseña
		 String internalSecretKey = "internalSecretKey";
		 http.rememberMe().rememberMeServices(rememberMeServices(internalSecretKey)).key(internalSecretKey);*/
		
	}
    
	/*OTRO INTENTO DE RECORDAR LA CONTRASEÑA
	 * @Autowired
	DataSource dataSource;

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler
	            savedRequestAwareAuthenticationSuccessHandler() {
	
	           SavedRequestAwareAuthenticationSuccessHandler auth
	                = new SavedRequestAwareAuthenticationSuccessHandler();
		auth.setTargetUrlParameter("targetUrl");
		return auth;
	}*/
	
	/*
	 * Intento de recordar mi contraseña en el ordenador
	@Bean
	 public RememberMeServices rememberMeServices(String internalSecretKey) {
	    TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("password", userDetailsService());
	    rememberMeServices.setCookieName("cookieName");
	    rememberMeServices.setParameter("rememberMe");

	    return rememberMeServices;
	 }*/

}
