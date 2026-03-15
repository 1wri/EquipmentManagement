package com.rain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Baoxiu;
import com.rain.domain.Equipment;
import com.rain.service.RainService;

@Controller
public class BaoxiuController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	@RequestMapping(value="/baoxiu/list",method=RequestMethod.GET)
	 public String index(Model model){
		List<Baoxiu> baoxiu_list = rainservice.findAllBaoxiu();
		model.addAttribute("list",baoxiu_list);
		return "baoxiu/list";
	}
	@RequestMapping(value="/baoxiu/add",method=RequestMethod.GET)
	 public String add(Model model,Integer id){
		if(id!=null){
			Baoxiu baoxiu = rainservice.get_BaoxiuInfo(id);
			model.addAttribute("baoxiu",baoxiu);
		}
		List<Equipment> equipment_list=rainservice.findAllEquipment();
		model.addAttribute("equipment_list",equipment_list);
		return "/baoxiu/add";
	}
	@RequestMapping(value="/baoxiu/add",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Baoxiu baoxiu ,Integer id){
		if(id!=null){
			rainservice.update_BaoxiuInfo(baoxiu);
		}else{
			rainservice.addBaoxiu(baoxiu);
		}
		mv.setViewName("redirect:/baoxiu/list");
		return mv;
	}
	@RequestMapping(value="/baoxiu/delete",method=RequestMethod.GET)
	 public void delete(Integer id){
		if(id!=null){
			rainservice.delete_BaoxiuInfo(id);
		}
	}
}
