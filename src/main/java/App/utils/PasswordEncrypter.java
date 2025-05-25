package App.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {

	private static final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	public static String passwordHash(String  plainPassword)
	{
		 return encoder.encode(plainPassword);
	}
	
	public static boolean compare( String rawPassword,String hashedPassword) 
	{
		return encoder.matches(rawPassword, hashedPassword);
	}
}
