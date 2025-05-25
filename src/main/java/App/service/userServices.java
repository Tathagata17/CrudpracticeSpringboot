package App.service;

import org.springframework.stereotype.Service;

import App.model.Users;
import App.repository.UserRepository;

@Service
public class userServices {

	private final UserRepository userRepo;
	
	public userServices(UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	
	public void userSignup(Users user)
	{
		//userRepo.save()
	}
	
}
