package App.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.dto.LoginRequest;
import App.model.Users;

@RestController
@RequestMapping("/user")
public class UserController {

	public String userSignup(@RequestBody Users user)
	{
		return "done";
	}
	public String Userlogin(@RequestBody LoginRequest loginRequest)
	{
		return  "done";
	}
}
