package App.service;

import org.springframework.stereotype.Service;

import App.model.Users;
import App.repository.UserRepository;
import App.utils.JwtService;
import App.utils.PasswordEncrypter;

@Service
public class userServices {

	private final UserRepository userRepo;
	private final JwtService jwtservice;

	public userServices(UserRepository userRepo,JwtService jwtservice) {
		this.userRepo = userRepo;
		this.jwtservice=jwtservice;
	}

	public boolean userSignup(Users user) {
	    if (userRepo.findByEmail(user.getEmail()) == null) {
	        userRepo.save(user);
	        return true;
	    }
	    return false; // user already exists
	}


	public String userlogin(String email, String rawPassword) {
		System.out.println("reached");
		String hashedpassword = null;
		Users user = userRepo.findByEmail(email);
		hashedpassword = user.getPassword();
		boolean userStatus=PasswordEncrypter.compare(rawPassword, hashedpassword);
		if(userStatus)
		{
			return jwtservice.generateToken(user.getEmail());
		}
		return "wrong password";
	}
}
