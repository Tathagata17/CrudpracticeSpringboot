package App.service;

import org.springframework.stereotype.Service;

import App.model.Users;
import App.repository.UserRepository;
import App.utils.PasswordEncrypter;

@Service
public class userServices {

	private final UserRepository userRepo;

	public userServices(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	public boolean userSignup(Users user) {
		boolean actresult=false;
		if(userRepo.findByEmail(user.getEmail())!=null)
		{
		userRepo.save(user);
		actresult=true;
		}
		else
		{
			actresult= false;
		}
		return actresult;
	}
	public boolean userlogin(String email, String rawPassword) {
		String hashedpassword = null;
		Users user = userRepo.findByEmail(email);
		hashedpassword = user.getPassword();
		return PasswordEncrypter.compare(rawPassword, hashedpassword);

	}
}
