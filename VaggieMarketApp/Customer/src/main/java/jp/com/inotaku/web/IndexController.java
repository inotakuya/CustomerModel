package jp.com.inotaku.web;

import java.util.List;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		List<Item> itemList = itemService.findAllItems();
		model.addAttribute("itemList",itemList);
		return "index";
	}
	
	@RequestMapping(value="create" ,method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute(new Item());
		return "create";
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String register(@ModelAttribute Item item, Model model){
		itemService.saveItem(item);
		return "redirect:/";
	}

}
