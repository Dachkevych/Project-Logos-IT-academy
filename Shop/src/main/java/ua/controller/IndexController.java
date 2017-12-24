package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.service.CommodityService;

@Controller
public class IndexController {
	
	private final CommodityService service;
	
	@Autowired
	public IndexController(CommodityService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String welcome(Model model,@PageableDefault(9) Pageable pageable){
		model.addAttribute("commodities", service.findCommodityIndex(pageable));
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	@GetMapping("/commodity/{id}")
	public String commodity(Model model, @PathVariable Integer id) {
		model.addAttribute("commodity", service.findOne(id));
		return "items";
	}
	
}
