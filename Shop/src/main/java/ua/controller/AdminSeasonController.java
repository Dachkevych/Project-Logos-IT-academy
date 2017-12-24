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
import ua.entity.Season;
import ua.service.SeasonService;

@Controller
@RequestMapping("/admin/season")
public class AdminSeasonController {
	
	private final SeasonService service;

	@Autowired
	public AdminSeasonController(SeasonService service) {
		this.service = service;
	}
	
	@ModelAttribute("season")
	public Season getForm() {
		return new Season();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	private String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("seasons", service.findAll(pageable, filter));
		return "season";
	}
	
	@PostMapping
	public String add(@ModelAttribute("season") @Valid Season season, BindingResult br, Model model, SessionStatus ss, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			show(model, pageable, filter);
			return "season";
		}
		service.save(season);
		ss.setComplete();
		return "redirect:/admin/season";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("season", service.findOne(id));
		show(model, pageable, filter);
		return "season";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/season";
	}
}
