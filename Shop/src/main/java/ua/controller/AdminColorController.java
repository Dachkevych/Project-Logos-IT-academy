package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.filter.SimpleFilter;
import ua.entity.Color;
import ua.service.ColorService;

@Controller
@RequestMapping("/admin/color")
public class AdminColorController {
	
	private final ColorService service;

	@Autowired
	public AdminColorController(ColorService service) {
		this.service = service;
	}
	
	@ModelAttribute("color")
	public Color getForm() {
		return new Color();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("colors", service.findAll(pageable, filter));
		return "color";
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@PostMapping
	public String add(@ModelAttribute("color") @Valid Color color, BindingResult br, Model model, SessionStatus ss, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			show(model, pageable, filter);
			return "color";
		}
		service.save(color);
		ss.setComplete();
		return "redirect:/admin/color";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("color", service.findOne(id));
		show(model, pageable, filter);
		return "color";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/color";
	}
	

}
