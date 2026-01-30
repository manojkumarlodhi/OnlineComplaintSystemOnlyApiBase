package com.dollop.OnlineComplaintSystem.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		log.info("Incoming request: {}", request.getRequestURI());
		String requestTokenheader = request.getHeader("Authorization");
		String token = null;
		String email = null;

		if (requestTokenheader != null && requestTokenheader.startsWith("Bearer ")) {
			token = requestTokenheader.substring(7);
			try {

				email = jwtTokenProvider.getEmailFromToken(token);
			} catch (Exception ex) {
				log.warn("Authorization header missing or does not start with Bearer");
			}
		} else {
			log.warn("Authorization header missing or does not start with Bearer jh");
		}

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetailService = userDetailsService.loadUserByUsername(email);

			if (jwtTokenProvider.validateToken(token)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetailService, null, userDetailService.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				log.info("Authentication set for user: {}", email);

			} else {
				log.warn("Invalid JWT token for user: {}", email);
			}
		}

		filterChain.doFilter(request, response);

	}


}
