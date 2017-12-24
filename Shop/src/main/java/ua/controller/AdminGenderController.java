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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.filter.SimpleFilter;
import ua.entity.Gender;
import ua.service.GenderService;

@Controller
@RequestMapping("/admin/gender")
@SessionAttributes("gender")
public class AdminGenderController {

	private final GenderService service;

	@Autowired
	public AdminGenderController(GenderService service) {
		this.service = service;
	}
	
	@ModelAttribute("gender")
	public Gender getForm() {
		return new Gender();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("genders", service.findAll(pageable, filter));
		return "gender";
	}
	
	@PostMapping
	public String add(@ModelAttribute("gender") @Valid Gender gender, BindingResult br, Model model, SessionStatus ss, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			show(model, pageable, filter);
			return "gender";
		}
		service.save(gender);
		ss.setComplete();
		return "redirect:/admin/gender";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("gender", service.findOne(id));
		show(model, pageable, filter);
		return "gender";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/gender";
	}
	
	
}
