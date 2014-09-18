package jp.com.inotaku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/message")
public class BlogController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String message(Model model){
		model.addAttribute("message","メッセージ");
		return "showMessage";
	}
}
