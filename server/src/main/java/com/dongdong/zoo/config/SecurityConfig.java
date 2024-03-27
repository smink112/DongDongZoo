package com.dongdong.zoo.config;

import com.dongdong.zoo.security.authentication.provider.CustomAuthenticationProvider;
import com.dongdong.zoo.security.filter.TokenAuthenticationFilter;
import com.dongdong.zoo.security.filter.TokenIssueFilter;
import com.dongdong.zoo.security.filter.TokenWithdrawalFilter;
import com.dongdong.zoo.security.service.CustomUserDetailsService;
import com.dongdong.zoo.security.service.TokenManagementService;
import com.dongdong.zoo.security.token.TokenHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final CustomUserDetailsService userDetailsService;
	private final TokenManagementService tokenManagementService;
	private final TokenHandler tokenHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.httpBasic(Customizer.withDefaults())
//			.httpBasic(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.csrf(AbstractHttpConfigurer::disable)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(
				requests -> requests
					.anyRequest().permitAll()
			)
			.addFilterBefore(tokenAuthenticationFilter(), BasicAuthenticationFilter.class)
			.addFilterAfter(tokenIssueFilter(), BasicAuthenticationFilter.class) // todo: 순서 -> 인증 및 권환 확인 이후
			.addFilterAfter(tokenWithdrawalFilter(), BasicAuthenticationFilter.class) // todo: 순서 -> 인증 및 권환 확인 이후?
			.build();
	}

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter(tokenHandler, tokenManagementService, tokenAuthenticationFilterIgnoredPatterns());
	}

	@Bean
	public TokenIssueFilter tokenIssueFilter() {
		return new TokenIssueFilter(tokenHandler, tokenManagementService, tokenIssueFilterPatterns());
	}

	@Bean
	public TokenWithdrawalFilter tokenWithdrawalFilter() {
		return new TokenWithdrawalFilter(tokenHandler, tokenManagementService, tokenWithdrawalFilterPatterns());
	}

	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider(userDetailsService, passwordEncoder());
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		return authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider())
			.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // todo
	}

	private List<String> tokenAuthenticationFilterIgnoredPatterns() {
		return List.of("/auth/login", "/auth/signup");
	}

	private List<String> tokenIssueFilterPatterns() {
		return List.of("/auth/login", "/auth/reissue");
	}

	private List<String> tokenWithdrawalFilterPatterns() {
		return List.of("/auth/logout");
	}
}