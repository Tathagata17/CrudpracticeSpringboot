package App.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTHandler {

	private static final long EXPIRATION_TIME = 60 * 60 * 1000;
	private static final String SECRET_KEY = "your_secret_key";

	public String generateJWTToken(String userEmail) {
	String token=JWT.create().withSubject(userEmail).withIssuedAt(new Date()) // token issued at
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // token expiration
				.sign(Algorithm.HMAC256(SECRET_KEY));
		
		
		return token;
	}
}
