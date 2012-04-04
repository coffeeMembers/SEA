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
		modelMap.addAttribute("userList", userService.findAllUsers());
		modelMap.addAttribute("user", new User());
		return new ModelAndView("userForm", modelMap);
	}

    @RequestMapping("/user/update.html")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Long userId) throws Exception {
        User user = userService.findUserById(userId);
        user.setName("llllllllll");
        userService.update(user);
        return new ModelAndView("redirect:list.html");
    }

    @RequestMapping("/user/delete.html")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Long userId) throws Exception {
        userService.delete(userId);
        return new ModelAndView("redirect:list.html");
    }
}
