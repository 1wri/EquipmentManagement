package com.rain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Root;
import com.rain.domain.User;
import com.rain.service.RainService;
import com.rain.util.common.Constants;

@Controller
public class UserController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/user/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("/user/list");
			return mv;
		}
//		退出功能
		@RequestMapping(value="/user/logout")
		 public ModelAndView logout(ModelAndView mv, HttpSession session){
			session.setAttribute(Constants.USER_SESSION, null);
			session.setAttribute("tip", null);
			mv.setViewName("redirect:/loginForm");
			
			return mv;
		}
		@RequestMapping(value="/login")
		 public ModelAndView login(@RequestParam("loginname") String loginname,
				 @RequestParam("password") String password,
				 @RequestParam("tip") String tip,
				 HttpSession session,
				 ModelAndView mv){
			if("1".equals(tip)) {
				Root user = rainservice.login(loginname, password);
				if(user!=null){
					// 将用户保存到HttpSession当中
					session.setAttribute(Constants.USER_SESSION, user);
					session.setAttribute("tip", "1");
					// 客户端跳转到main页面
					mv.setViewName("redirect:/indexroot/");
				}else{
					// 设置登录失败提示信息
					System.out.println("设置登录失败提示信息");
					mv.addObject("message", "登录名或密码错误!请重新输入");
					// 服务器内部跳转到登录页面
					mv.setViewName("forward:/loginForm");
				}
			}else {
				User user = rainservice.login2(loginname, password);
				if(user!=null){
					// 将用户保存到HttpSession当中
					System.out.println("HttpSession");
					session.setAttribute(Constants.USER_SESSION, user);
					session.setAttribute("tip", "2");
					// 客户端跳转到main页面
					mv.setViewName("redirect:/indexuser/");
				}else{
					// 设置登录失败提示信息
					System.out.println("设置登录失败提示信息");
					mv.addObject("message", "登录名或密码错误!请重新输入");
					// 服务器内部跳转到登录页面
					mv.setViewName("forward:/loginForm");
				}
				
			}
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/user/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/user/list";
			return blank;
		}
		@RequestMapping(value="/user/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<User> user_list = rainservice.get_UserList();
			if (content!=null){
				user_list = rainservice.get_UserLikeList(content);
			}
			model.addAttribute("list",user_list);
			return "user/list";
		}
		
		
		@RequestMapping(value="/user/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				User user = rainservice.get_UserInfo(id);
				model.addAttribute("user",user);
			}
			return "/user/add";
		}

		
		@RequestMapping(value="/user/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute User notice ,Integer id){
			if(id!=null){
				rainservice.update_UserInfo(notice);
			}else{
				rainservice.insert_UserInfo(notice);
			}
			mv.setViewName("redirect:/user/list");
			return mv;
		}
		
		@RequestMapping(value="/user/pass",method=RequestMethod.GET)
		 public String passadd(Model model,Integer id){
			if(id!=null){
				User user = rainservice.get_UserInfo(id);
				model.addAttribute("user",user);
			}
			return "/user/pass";
		}

		
		@RequestMapping(value="/user/pass",method=RequestMethod.POST)
		 public ModelAndView passadd(@ModelAttribute User notice ,Integer id,ModelAndView mv){

				rainservice.update_UserInfo(notice);

			mv.setViewName("redirect:/user/list");
			return mv;
		}
		
		@RequestMapping(value="/user/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			if(id!=null){
				rainservice.delete_UserInfo(id);
			}
		}

//		@RequestMapping(value="/user/myjianli",method=RequestMethod.GET)
//		 public String update1(Model model,HttpSession session){
//			User user = (User) session.getAttribute(Constants.USER_SESSION);
//			model.addAttribute("job",user);
//			return "/user/myjianli";
//		}
//		@RequestMapping(value="/user/myjianli",method=RequestMethod.POST)
//		 public ModelAndView update1(ModelAndView mv,Model model,HttpSession session,User notice1){
//			User user1 = (User) session.getAttribute(Constants.USER_SESSION);
//			user1.setUsername(notice1.getUsername());
//			user1.setUserphone(notice1.getUserphone());
//			user1.setUserschool(notice1.getUserschool());
//			user1.setUserage(notice1.getUserage());
//			user1.setUserinstruction(notice1.getUserinstruction());
//			rainservice.update_UserInfo(user1);
//				session.setAttribute(Constants.USER_SESSION, user1);
//				mv.setViewName("redirect:/user/myjianli");
//				return mv;
//		}
}
