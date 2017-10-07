package com.bcj.helpdesk.controller.tickets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bcj.helpdesk.model.tickets.Tickets;
import com.bcj.helpdesk.service.tickets.TicketsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Harsha Kocherla
 * 
 * This is a Controller class which has different methods that return appropriate jsp pages for a valid request.
 */
/**
 * @author Harsha Kocherla
 */
@Controller

public class TicketsController {

	@Autowired
	private TicketsService ticketsService;
	
	
	/**
	 * @param tickets
	 * @param model
	 * @param session
	 * @return {@link ModelAndView} object
	 * 
	 * for /createTicket request this method returns login.jsp page through view resolver after saving the ticket details 
	 * created by the user.
	 * 
	 * This method calls saveTicket() method of TicketsService class to check whether the ticket details are stored in data base.
	 * 
	 * This method uses session attributes like username and loginId which are set at the time of login.
	 */
	
	
	@RequestMapping(value = "/createTicket", method = RequestMethod.POST)
	public ModelAndView createTicket(Tickets tickets,Model model, HttpSession session){
		
		System.out.println("session iD : "+ session.getId());
		System.out.println("session loginID at tickets COntroller: "+session.getAttribute("loginId"));
		
		String username = (String)session.getAttribute("username");
		int loginId = (Integer) session.getAttribute("loginId");
		
		System.out.println("login id at createTicket : "+ loginId);
		
		ModelAndView mav =null;

		if(ticketsService.saveTicket(tickets,loginId,username)){
		
		mav = new ModelAndView("login");
		mav.addObject("message", username);
		
			return mav;
			
		}else{
			
			mav = new ModelAndView("login");
			mav.addObject("error_message", "Could not save the ticket, please re-submit");
			
			return mav;
		}
		
	}
	
	/**
	 * @param session
	 * @return {@link ModelAndView} object
	 * 
	 * for /displayCreateTickets request this method returns tickets.jsp through view resolver.
	 * displyCreateTickets request is made when create tickets button is pressed on login page of student or consultant.
	 * 
	 * 
	 * session attribute like loginId is added to the tickets page and also a random number is added.
	 * random alphanumeric value is returned by calling randomAlphaNumeric() method of TicketsService class.
	 * 
	 */
	
	
	@RequestMapping(value = "/displayCreateTickets")
	public ModelAndView displayCreateTicket(HttpSession session){
		
		System.out.println((String)session.getId());
		
		ModelAndView mav = new ModelAndView("tickets");
		
		mav.addObject("ticketId", TicketsService.ticketNumber(6));
		mav.addObject("loginId", session.getAttribute("loginId"));
		mav.addObject("category", ticketsService.retrieveCategory());
		
		return mav;
	}
	
	/**
	 * @param session
	 * @return String 
	 * 
	 * for the ajax call in studentTickets.jsp with url displayTickets this method returns List of ticket data which is 
	 * converted to json format.
	 * 
	 * This method uses session attributes like loginId.
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/displayTickets")
	public String myTickets(HttpSession session){
		
		System.out.println("at displayTickets - my tickets");
		System.out.println(session.getId());
		
		int loginId = (Integer)session.getAttribute("loginId");
		
		System.out.println(loginId + "at mytickets- displaytickets");
		
		List<Tickets> myTickets = ticketsService.retrieveTicketsData(loginId);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(myTickets);
		return jsonArray;

	}
	
	/**
	 * @param category
	 * @return String
	 * 
	 * for an ajax call with url loadSubCat in tickets.jsp this method returns a String of sub categories
	 * 
	 * retrieveSubCategory() method of TicketsService is called to retrieve the sub categories from data base.
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/loadSubCat", method =RequestMethod.POST)
	public String loadSubCat(@RequestBody String category){
		
		List<String> subCategory = ticketsService.retrieveSubCategory(category);
		
		String subCategoryHtmlStr = "";
		
		for(String subC : subCategory){
			
			subCategoryHtmlStr+="<option value = '"+subC+"'>" +subC+"</option>";
			
		}
		
		return subCategoryHtmlStr;
		
	}
	
	
	/**
	 * @return String 
	 * 
	 * for a request /studentTickets which happens when My Tickets button is pressed at students login view
	 * this method returns studentTickets.jsp through view resolver.
	 */
	
	
	@RequestMapping(value = "/studentTickets")
	public String studentTickets(){
		
		System.out.println("harsha");
		return "studentTickets";
		
	}
	
	
	/**
	 * @param session
	 * @return {@link ModelAndView} object
	 * 
	 * for a request /returntologin which happens whenever user clicks on home button when he is logged in 
	 * this method returns the login view based on the userType.
	 * 
	 */
	
	
	@RequestMapping("/returntologin")
	public ModelAndView returnToLogin(HttpSession session){
		
		String message = (String) session.getAttribute("username");
		String userType = (String)session.getAttribute("userType");
		
		System.out.println(message +" at ticket controller");
		
		ModelAndView mav = null;
		if("employ".equals(userType)){
		
				mav = new ModelAndView("employlogin");
				mav.addObject("message", message);
				
				return mav;
				
		}else{
			
			mav = new ModelAndView("login");
			mav.addObject("message", message);
			
			return mav;
		}
	}
	
	
}
