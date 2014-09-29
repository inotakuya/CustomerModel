package jp.com.inotaku.controller;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item",method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("itemList",itemService.getItemList());
		return "index";
	}
	
	@RequestMapping(value = "/init",method = RequestMethod.GET)
	public String create(){
		Item item1 = new Item("冷蔵庫", 10000, "４ドア冷蔵庫（３５５Ｌ・右開き）");
		Item item2 = new Item("洗濯機", 5000, "全自動洗濯機（5．5kg） ");
		itemService.addItem(item1);
		itemService.addItem(item2);
		return "redirect:/item";
	}
	
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public String detail(long itemId, Model model){
		model.addAttribute("item",itemService.getItemByItemId(itemId));
		return "detail";
	}
}
