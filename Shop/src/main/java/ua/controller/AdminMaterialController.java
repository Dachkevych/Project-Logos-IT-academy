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
import ua.entity.Material;
import ua.service.MaterialService;

@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class AdminMaterialController {

	private final MaterialService service;

	@Autowired
	public AdminMaterialController(MaterialService service) {
		this.service = service;
	}
	
	@ModelAttribute("material")
	public Material getForm() {
		return new Material();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("materials", service.findAll(pageable, filter));
		return "material";
	}
	
	@PostMapping
	public String add(@ModelAttribute("material") @Valid Material material, BindingResult br, Model model, SessionStatus ss, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			show(model, pageable, filter);
			return "material";
		}
		service.save(material);
		ss.setComplete();
		return "redirect:/admin/material";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("material", service.findOne(id));
		show(model, pageable, filter);
		return "material";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/material";
	}
	
	
}
