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

import com.rain.domain.Caigou;
import com.rain.domain.Equipment;
import com.rain.service.RainService;

@Controller
public class CaigouController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	@RequestMapping(value="/caigou/list",method=RequestMethod.GET)
	 public String index(Model model,String content){
		List<Caigou> caigou_list = rainservice.findAllCaigou();
		if (content!=null){
			caigou_list = rainservice.findAllCaigou(content);
		}
		
		model.addAttribute("list",caigou_list);
		return "caigou/list";
	}
	@RequestMapping(value="/caigou/add",method=RequestMethod.GET)
	 public String add(Model model,Integer id){
		if(id!=null){
			Caigou caigou = rainservice.get_CaigouInfo(id);
			model.addAttribute("caigou",caigou);
		}
		List<Equipment> equipment_list=rainservice.findAllEquipment();
		model.addAttribute("equipment_list",equipment_list);
		return "/caigou/add";
	}
	@RequestMapping(value="/caigou/add",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Caigou caigou ,Integer id){
		if(id!=null){
			rainservice.update_CaigouInfo(caigou);
		}else{
			rainservice.addCaigou(caigou);
		}
		mv.setViewName("redirect:/caigou/list");
		return mv;
	}
	@RequestMapping(value="/caigou/delete",method=RequestMethod.GET)
	 public void delete(Integer id){
		if(id!=null){
			rainservice.delete_CaigouInfo(id);
		}
	}
}
