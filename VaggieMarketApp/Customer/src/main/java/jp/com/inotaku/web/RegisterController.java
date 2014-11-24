package jp.com.inotaku.web;

import jp.com.inotaku.domain.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

	@RequestMapping(method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute("customer",new Customer());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processRegister(@ModelAttribute Customer customer,Model model){
		return "redirect:/";
	}
}
