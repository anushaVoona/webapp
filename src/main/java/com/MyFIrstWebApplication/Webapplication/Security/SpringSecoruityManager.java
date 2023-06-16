package com.MyFIrstWebApplication.Webapplication.Security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecoruityManager {

	/*
	 * 
	 * @Bean public InMemoryUserDetailsManager createUserDetailsManager() {
	 * 
	 * Function<String, String> passwordEncoder = input ->
	 * passwordEncoder().encode(input);
	 * 
	 * UserDetails userDetails =
	 * User.builder().passwordEncoder(passwordEncoder).username("Anusha").password(
	 * "anu") .roles("USER", "ADMIN").build(); return new
	 * InMemoryUserDetailsManager(userDetails); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Bean
	public InMemoryUserDetailsManager createUserDetails() {

		UserDetails admin = createUser("Anusha", "anu");

		UserDetails user = createUser("Jagadeesh", "jag");
		return new InMemoryUserDetailsManager(user, admin);

	}

	private UserDetails createUser(String name, String password)

	{
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		return User.builder().passwordEncoder(passwordEncoder).username(name).password(password).roles("USER", "ADMIN")
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();

	}

}
