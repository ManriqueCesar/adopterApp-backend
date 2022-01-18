package com.adopter.app.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.adopter.app.models.dto.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;
	
	@Value("${jwt.secret}")
	private String secret;

	public String getIdUserFromToken(String token) {
		final Claims claims = getAllClaimsFromToken(token);
		return claims.getSubject();
	}

	public Date getExpirationDateFromToken(String token) {
		final Claims claims = getAllClaimsFromToken(token);
		return claims.getExpiration();
	}

	public Object getClaimFromToken(String token, String claimKey) {
		final Claims claims = getAllClaimsFromToken(token);
		return claims.get(claimKey);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration == null ? false : expiration.before(new Date());
	}

	// generate token for user
	public String generateToken(UserDto usuario) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", usuario.getIdUsuario());
		return doGenerateToken(claims, usuario.getUsuario());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(null).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// validate token
	public Boolean validateToken(String token, UserDetails user) {
		final String idUser = getIdUserFromToken(token);
		return (idUser.equals(user.getUsername()) && !isTokenExpired(token));
	}


}

