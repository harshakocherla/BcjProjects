package com.bcj.helpdesk.controller.registrationandlogin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcj.helpdesk.model.registerandlogin.Login;
import com.bcj.helpdesk.model.registerandlogin.User;
import com.bcj.helpdesk.service.registerandlogin.RegistrationAndLoginService;

/**
 * @author Harsha Kocherla
 * 
 * This is a Controller class which has different methods that return appropriate jsp pages for a valid request. 
 */
@Controller
public class HomeController {

	@Autowired
	private RegistrationAndLoginService rlService;
	
	

	/**
	 * @return ModelAndView object
	 * 
	 * For a /home request this method returns home.jsp through view resolver by adding two ArrayList objects to the page.
	 * 
	 */
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		
		List<String> userType = rlService.retrieveUserType();
		List<String> usStates = rlService.retrieveStates();
		
		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("usStates", usStates);
		mav.addObject("userType", userType);
		
		return mav;
	}

	/**
	 * @param user
	 * @param model
	 * @return a String
	 * 
	 *  for /signup request this method returns home.jsp page through view resolver after saving the user details into the data base
	 *  by calling saveUser() of RegistrationAndLoginService.
	 *  
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(User user, Model model) {
		
		List<String> userType = rlService.retrieveUserType();
		List<String> usStates = rlService.retrieveStates();
		
		ModelAndView mav = null;
		
		
		//if("User already exists!".equals(rlService.saveUser(user))){
		if(rlService.saveUser(user)==null){
			
			mav = new ModelAndView("signuperror");
			
			mav.addObject("usStates", usStates);
			mav.addObject("userType", userType);
			
			mav.addObject("message", "User already exists!");
			
		return mav;
		
		}else{
			
			mav = new ModelAndView("home");
			
			mav.addObject("usStates", usStates);
			mav.addObject("userType", userType);
			
			return mav;
		}
	}

	/**
	 * @param login
	 * @param model
	 * @param session
	 * @return {@link ModelAndView} object
	 * 
	 * for a /login request this method returns login.jsp page through view resolver based on the user type of the user.
	 * verifyUser() method of RegistrationAndLoginService is called to verify login details and to get user type.
	 * 
	 *  {@link HttpSession} is used to set three session attributes like loginId, username and userType.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Login login, Model model, HttpSession session) {
		
		ModelAndView mav = null;
		String userType = rlService.verifyUser(login);
		
		if ("student".equals(userType)||"consultant".equals(userType)) {
			
			session.setAttribute("loginId", login.getLoginId());
			session.setAttribute("username", login.getUsername());
			session.setAttribute("userType", userType);
			
			String user = (String) session.getAttribute("username");
			
			System.out.println(user+"at login");
			System.out.println("session iD : "+ session.getId());
			System.out.println("Session loginId at controller: "+ session.getAttribute("loginId"));
			
			mav = new ModelAndView("login");
			mav.addObject("message", "welcome "+login.getUsername());

			return mav;
			
		}else if("employ".equals(rlService.verifyUser(login))){
			
			session.setAttribute("loginId", login.getLoginId());
			session.setAttribute("username", login.getUsername());
			session.setAttribute("userType", userType);
			
			String user = (String) session.getAttribute("username");
			
			System.out.println("Session username at home controller"+user);
			System.out.println("Session loginId at controller: "+ session.getAttribute("loginId"));
			
			mav = new ModelAndView("employlogin");
			mav.addObject("message", "welcome "+login.getUsername());
			
			return mav;
			
		}else{
			
			mav = new ModelAndView("error");
			mav.addObject("message", "Please enter valid username and password!");
			
			return mav;
	}

	}
	
	
	
	/**
	 * @param session
	 * @return {@link ModelAndView} object
	 * 
	 * for /logout request this method invalidates the session that is start at the time of login.
	 * 
	 * 
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		
		List<String> userType = rlService.retrieveUserType();
		List<String> usStates = rlService.retrieveStates();
		
		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("usStates", usStates);
		mav.addObject("userType", userType);
		
		session.invalidate();
		
		return mav;
	}
	}
