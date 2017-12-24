package ua.controller;

import java.io.File;
import java.security.Principal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.request.CommodityRequest;
import ua.entity.*;
import ua.service.*;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class AdminCommodityController {
	
	private final CommodityService service;
	
	private final BrandService brandService;
	
	private final CategoryService categoryService;
	
	private final ColorService colorService;
	
	private final MaterialService materialService;
	
	private final SeasonService seasonService;
	
	private final GenderService genderService;

	@Autowired
	public AdminCommodityController(
			CommodityService service,
			BrandService brandService,
			CategoryService categoryService,
			ColorService colorService, 
			MaterialService materialService,
			SeasonService seasonService,
			GenderService genderService) {
		this.service = service;
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.colorService = colorService;
		this.materialService = materialService;
		this.seasonService = seasonService;
		this.genderService = genderService;
	}
	
	
	@Value("${file.path}")
	private String path;
	
	@ModelAttribute("commodity")
	public CommodityRequest getForm() {
		return new CommodityRequest();
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder webDataBinder) {
//		webDataBinder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
//		webDataBinder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
//		webDataBinder.registerCustomEditor(Color.class, new ColorEditor(colorService));
//		webDataBinder.registerCustomEditor(Gender.class, new GenderEditor(genderService));
//		webDataBinder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
//		webDataBinder.registerCustomEditor(Season.class, new SeasonEditor(seasonService));
//	}
	
	@GetMapping
	public String show(Model model, @PageableDefault(9) Pageable pageable) {
		System.out.println(pageable);
		model.addAttribute("commodities", service.findAll(pageable));
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("materials", materialService.findAll());
		model.addAttribute("seasons", seasonService.findAll());
		model.addAttribute("genders", genderService.findAll());
		model.addAttribute("sizeClotheses", Arrays.asList(SizeClothes.values()));
		model.addAttribute("sizeShoeses", Arrays.asList(SizeShoes.values()));
		return "commodity";
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String add(@ModelAttribute("commodity") CommodityRequest request, Principal principal, SessionStatus ss) {
		System.out.println(principal.getName());
		service.save(request);
		ss.setComplete();
		return "redirect:/admin/commodity";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Commodity commodity = service.findOne(id);
		File file = new File(path+commodity.getPhotoUrl());
		if(file!=null){
			file.delete();
		}
		service.delete(id);
		return "redirect:/admin/commodity";
	}	
	
	@GetMapping(params ={"page","size"})
	public Page<Commodity> get(Pageable p){	
		return service.findAll(p);
	}
}
