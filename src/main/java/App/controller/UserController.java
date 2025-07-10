package App.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.dto.LoginRequest;
import App.model.Users;
import App.service.userServices;
import App.utils.PasswordEncrypter;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final userServices userService;
	
	public UserController(userServices userServices)
	{
		this.userService=userServices;
	}
	@PostMapping("/usersignup")
	public String userSignup(@RequestBody Users user)
	{
		 String HashedPassword =PasswordEncrypter.passwordHash(user.getPassword());
		 user.setPassword(HashedPassword);
		 if(userService.userSignup(user))
		 {
		 return "done";
		 }
		 return "not done";
	}
	@PostMapping("/userlogin")
	public String Userlogin(@RequestBody LoginRequest loginRequest)
	{
		String email=loginRequest.getEmail();
		String token= userService.userlogin(email,loginRequest.getPassword());
		return token;
	}
}
