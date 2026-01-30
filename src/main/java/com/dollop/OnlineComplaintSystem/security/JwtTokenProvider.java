package com.dollop.OnlineComplaintSystem.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dollop.expensetracker.exception.JwtTokenExpiredException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtTokenProvider {
	@Value("${jwt.secret}")
	private String SECRET ;
	@Value("${jwt.access-token-expiration}")
	private long EXPIRATION;
	
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	}
	
	public String generatedToken(String email) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + EXPIRATION);

		return Jwts.builder().setSubject(email).setIssuedAt(now).setExpiration(expiry)
				.signWith(getSecretKey(), SignatureAlgorithm.HS512).compact();

	}
	
	
	public String getEmailFromToken(String token) {
		System.out.println("Get email jwt util method");
		try {
			System.out.println("try block start ");
			Claims claims = Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token).getBody();
			System.out.println("try block end ");
			return claims.getSubject();
		} catch (ExpiredJwtException e) {

			throw new JwtTokenExpiredException("JWT token expired", e);
		} catch (JwtException e) {
			throw new JwtTokenExpiredException("Invalid JWT token", e);
		} catch (Exception e) {
			throw new JwtTokenExpiredException("Invalid ", e);
		}

	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException ex) {
			throw new JwtTokenExpiredException("Invalid JWT token", ex);
		}
	}


}
