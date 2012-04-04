package cn.teamwork.modules.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.teamwork.modules.login.businese.UserService;
import cn.teamwork.modules.login.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/add.html")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		userService.save(user);
		return new ModelAndView("redirect:list.html");
	}

	@RequestMapping("/user/list.html")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("userList", userService.findAll());
		modelMap.addAttribute("user", new User());
		return new ModelAndView("userForm", modelMap);
	}
}
