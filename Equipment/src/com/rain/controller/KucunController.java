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

import com.rain.domain.Chuku;
import com.rain.domain.Equipment;
import com.rain.domain.Ruku;
import com.rain.service.RainService;

@Controller
public class KucunController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;

	@RequestMapping(value="/kucun/rukulist",method=RequestMethod.GET)
	 public String rukuindex(Model model,String content){
		List<Ruku> ruku_list = rainservice.findAllRuku();
		if (content!=null){
			ruku_list = rainservice.findAllRuku(content);
		}
		
		model.addAttribute("rukulist",ruku_list);
		return "kucun/rukulist";
	}
	@RequestMapping(value="/kucun/rukuadd",method=RequestMethod.GET)
	 public String rukuadd(Model model,Integer id){
		if(id!=null){
			Ruku ruku = rainservice.get_RukuInfo(id);
			model.addAttribute("ruku",ruku);
		}
		List<Equipment> equipment_list=rainservice.findAllEquipment();
		model.addAttribute("equipment_list",equipment_list);
		return "/kucun/rukuadd";
	}
	@RequestMapping(value="/kucun/rukuadd",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Ruku ruku ,Integer id){
		if(id!=null){
			rainservice.update_RukuInfo(ruku);
		}else{
			rainservice.addRuku(ruku);
		}
		mv.setViewName("redirect:/kucun/rukuadd");
		return mv;
	}
	@RequestMapping(value="/kucun/rukudelete",method=RequestMethod.GET)
	 public void rukudelete(Integer id){
		if(id!=null){
			rainservice.delete_RukuInfo(id);
		}
	}
	
	
	
	
	@RequestMapping(value="/kucun/chukulist",method=RequestMethod.GET)
	 public String chukuindex(Model model,String content){
		List<Chuku> chuku_list = rainservice.findAllChuku();
		if (content!=null){
			chuku_list = rainservice.findAllChuku(content);
		}
		
		model.addAttribute("chukulist",chuku_list);
		return "kucun/chukulist";
	}
	@RequestMapping(value="/kucun/chukuadd",method=RequestMethod.GET)
	 public String chukuadd(Model model,Integer id){
		if(id!=null){
			Chuku chuku = rainservice.get_ChukuInfo(id);
			model.addAttribute("chuku",chuku);
		}
		List<Equipment> equipment_list=rainservice.findAllEquipment();
		model.addAttribute("equipment_list",equipment_list);
		return "/kucun/chukuadd";
	}
	@RequestMapping(value="/kucun/chukuadd",method=RequestMethod.POST)
	 public ModelAndView chukuadd(ModelAndView mv,@ModelAttribute Chuku chuku ,Integer id){
		if(id!=null){
			rainservice.update_ChukuInfo(chuku);
		}else{
			rainservice.addChuku(chuku);
		}
		mv.setViewName("redirect:/kucun/chukuadd");
		return mv;
	}
	@RequestMapping(value="/kucun/chukudelete",method=RequestMethod.GET)
	 public void chkudelete(Integer id){
		if(id!=null){
			rainservice.delete_ChukuInfo(id);
		}
	}
	
	
	
	
	@RequestMapping(value="/kucun/kucunlist",method=RequestMethod.GET)
	 public String index(Model model,String content){
		List<Equipment> equipment_list = rainservice.findAllEquipment();
		if (content!=null){
			equipment_list = rainservice.findAllEquipment(content);
		}
		
		model.addAttribute("list",equipment_list);
		return "kucun/kucunlist";
	}
	
}
