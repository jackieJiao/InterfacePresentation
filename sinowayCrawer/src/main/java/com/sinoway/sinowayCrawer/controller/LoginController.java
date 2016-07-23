package com.sinoway.sinowayCrawer.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinoway.sinowayCrawer.entitys.UserInfo;
import com.sinoway.sinowayCrawer.service.LoginService;
import com.sinoway.sinowayCrawer.service.UserInfoService;


@Controller
@RequestMapping("/auth")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	@RequestMapping(value = "/welcome.action")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response, String userName, String userPsw) {
		String page = "redirect:/query.jsp";
        if(userName!=null){
        	userName =userName.toLowerCase();
        }
        UserInfo user = loginService.selectUserForLogin(userName, userPsw);
        
        if (null != user) {
        	request.getSession().setAttribute("user", user);
//        	UserInfo _u = new UserInfo();
//        	_u.setId(user.getId());
//        	_u.setLastLoginTime(new Date());
//        	userInfoService.updateUserInfo(_u);
        } else {
        	request.setAttribute("msg", "用户名或者密码错误！");
        	page = "redirect:/login.jsp";
        }

		return new ModelAndView(page);
	}

	@RequestMapping(value = "/returnMain.action")
	public ModelAndView returnMain(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute("user");
		}
		return new ModelAndView("main");
	}	
	
	@RequestMapping(value = "/logout.action")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute("user");
		}
		return new ModelAndView("redirect:/login.jsp");
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "erro", required = false) boolean error, 
			ModelMap model) {

		/*logger.debug("Received request to show login page");*/

		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		return "login";
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)  
    public String getDeniedPage() {  
  
  /*      logger.debug("Received request to show denied page");  */
  
        return "denied";  
  
    }  
}
