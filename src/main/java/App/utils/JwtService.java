package App.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;

@Component
public class JwtService {

	private static final String Secretcode = "hellothisismysecretkeythatiwilluse";

	private final SecretKey key = Keys.hmacShaKeyFor(Secretcode.getBytes());

	Map<String, Object> claims = new HashMap<>();

	private final MacAlgorithm algorithm = SIG.HS256;

	public String generateToken(String userName) {

		return Jwts.builder().claims().add(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).and().signWith(key, algorithm)
				.compact();

	}

	public boolean validateToken(String token) {
		try {
			extractAllClaims(token); // Will throw if token is invalid
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
	}
}
