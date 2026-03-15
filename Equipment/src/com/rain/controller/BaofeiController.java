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

import com.rain.domain.Baofei;
import com.rain.domain.Equipment;
import com.rain.service.RainService;

@Controller
public class BaofeiController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	@RequestMapping(value="/baofei/list",method=RequestMethod.GET)
	 public String index(Model model){
		List<Baofei> baofei_list = rainservice.findAllBaofei();
		model.addAttribute("list",baofei_list);
		return "baofei/list";
	}
	@RequestMapping(value="/baofei/add",method=RequestMethod.GET)
	 public String add(Model model,Integer id){
		if(id!=null){
			Baofei baofei = rainservice.get_BaofeiInfo(id);
			model.addAttribute("baofei",baofei);
		}
		List<Equipment> equipment_list=rainservice.findAllEquipment();
		model.addAttribute("equipment_list",equipment_list);
		return "/baofei/add";
	}
	@RequestMapping(value="/baofei/add",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Baofei baofei ,Integer id){
		if(id!=null){
			rainservice.update_BaofeiInfo(baofei);
		}else{
			rainservice.addBaofei(baofei);
		}
		mv.setViewName("redirect:/baofei/list");
		return mv;
	}
	@RequestMapping(value="/baofei/yes",method=RequestMethod.GET)
	 public void yes(Integer id){
			String equipmentname=rainservice.get_BaofeiInfo(id).getEquipmentname();
			rainservice.baofei_Info(equipmentname);
			rainservice.yes_BaofeiInfo(id);
	}
	@RequestMapping(value="/baofei/no",method=RequestMethod.GET)
	 public void no(Integer id){
			rainservice.no_BaofeiInfo(id);
	}
}
