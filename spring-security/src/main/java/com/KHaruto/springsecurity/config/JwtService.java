package com.KHaruto.springsecurity.config;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "eNR3yn2YuFZCEqCNd5nBMrcGYBHPHqpJRF4aUGQ9wmTfotFZWa75WtqSf42Rj5z9gHC9Tsfk2DPsFJsXapc5R6YbqaDYo8cqCdmUQxWrfYDrczsjM7CdWW6mG9PsjpnnYdqeSkbwjHwokGXK9d7mBZyfHBBUG8mfRpNERHDTyPPzCdEQ6moK8W9H4Hu9nNEbKeacqSKEGsGNXmFQ8gXrhzokJtEepSR6YNLpX7EXGjuTcoatwWpAcAPfKAD5rud5";
	
	public String extractUsername(String token) {
		return null;
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();

	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
