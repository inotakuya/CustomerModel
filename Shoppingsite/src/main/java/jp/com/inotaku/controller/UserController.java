package jp.com.inotaku.controller;

import javax.validation.Valid;

import jp.com.inotaku.domain.User;
import jp.com.inotaku.service.UserService;
import jp.com.inotaku.validation.Login;
import jp.com.inotaku.validation.LoginForm;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLoginView(Model model){
		model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String onSubmit(@Validated(LoginForm.class) User user,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			return "login";
		}
		
		try {
			User loginUser = userService.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
			model.addAttribute("loginUser",loginUser);
		} catch (Exception e) {
			return "login";
		}
		return "loginSuccess";
	}
}
