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
import ua.entity.Category;
import ua.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class AdminCategoryController {

	private final CategoryService service;

	@Autowired
	public AdminCategoryController(CategoryService service) {
		this.service = service;
	}
	
	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("categorys", service.findAll(pageable, filter));
		return "category";
	}
	
	@PostMapping
	public String add(@ModelAttribute("category") @Valid Category category, BindingResult br, Model model, SessionStatus ss, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			show(model, pageable, filter);
			return "category";
		}
		service.save(category);
		ss.setComplete();
		return "redirect:/admin/category";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("category", service.findOne(id));
		show(model, pageable, filter);
		return "category";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/category";
	}
}
