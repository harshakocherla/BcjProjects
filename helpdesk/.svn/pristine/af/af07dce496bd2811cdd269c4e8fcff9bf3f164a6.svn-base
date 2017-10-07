package com.bcj.helpdesk.controller.ticketsmanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcj.helpdesk.dao.ticketsmanagement.TicketsManagementDao;
import com.bcj.helpdesk.model.tickets.Tickets;
import com.bcj.helpdesk.service.ticketsmanagment.TicketsManagementService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Harsha Kocherla
 * 
 * This is a Controller class which has different methods that return appropriate jsp pages for a valid request.
 */
@Controller
public class TicketsManagementController {
	
	@Autowired
	TicketsManagementService ticketsMngService;
	
	@Autowired
	TicketsManagementDao ticketsMngDao;
	
	/**
	 * @return String
	 * 
	 * for a request /employTickets which happens when employ clicks Ticket Management when he is logged in
	 * this method returns employTickets.jsp through view resolver.
	 */
	
	
	@RequestMapping("/employTickets")
	public String displayEmployView(){
		
		return "employTickets";
	}
	
	
	/**
	 * @return String
	 * 
	 * for the ajax call in the employTickets.jsp with url approvedTickets this method is called and it returns a List of 
	 * Tickets objects which is converted to json format.
	 * 
	 * retrieveApprovedTickets() of TicketsMngService is called to retrieve the approved tickets list.
	 * 
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("/approvedTickets")
	public String approvedTickets(){
		
		List<Tickets> approvedTickets = ticketsMngService.retrieveApprovedTickets();
		
		for(Tickets t: approvedTickets){
		System.out.println(t + "at approvedTickets ticketsMngController");
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(approvedTickets);
		return jsonArray;
	}
	
	
	
	/**
	 * @return String
	 * 
	 * for an ajax call in the employTickets.jsp page with url pendingTickets this method returns a List of Tickets objects
	 * which converted to json format.
	 * 
	 * retrievePendingTickets() method of TicketsMngService is called to retrieve the pending tickets data.
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("/pendingTickets")
	public String pendingTickets(){
		
		List<Tickets> pendingTickets = ticketsMngService.retrievePendingTickets();
		
		for(Tickets t: pendingTickets){
		System.out.println(t + "at pendingTickets ticketsMngController");
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(pendingTickets);
		
		return jsonArray;
	}
	
	
	
	/**
	 * @return String
	 * 
	 * for an ajax call in the employTickets.jsp page with url rejectedTickets this method returns a List of Tickets objects
	 * which is converted to json format
	 * 
	 * retrieveRejectedTickets() method of TicketsMngService is called to retrieve the Rejected Tickets data.
	 * 
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("/rejectedTickets")
	public String rejectedTickets(){
		
		List<Tickets> rejectedTickets = ticketsMngService.retrieveRejectedTickets();
		
		for(Tickets t: rejectedTickets){
		System.out.println(t + "at rejectedTickets ticketsMngController");
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonArray = gson.toJson(rejectedTickets);
		
		return jsonArray;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param ticketId
	 * @param comments
	 * 
	 * for an ajax call in employTickets.jsp with url approve which happens when the employ clicks on approve button of the jqgrid 
	 * this method updates the tickets table in data base.
	 * 
	 * this method updates stat and comments column of the tickets table for the given ticketId.
	 * annotation are used to hold the parameter values of the jsp page.
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("/approve")
	public void approveTickets(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("val") int ticketId, @RequestParam("comments") String comments){
		
		System.out.println("at approve");
		
		ticketsMngDao.approveTickets("approved", ticketId, comments);
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param ticketId
	 * @param comments
	 * for an ajax call in employTickets.jsp with url reject which happens when the employ clicks on reject button of the jqgrid 
	 * this method updates the tickets table in data base.
	 * 
	 * this method updates stat and comments column of the tickets table for the given ticketId.
	 * annotation are used to hold the parameter values of the jsp page.
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("/reject")
	public void rejectTickets(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("val") int ticketId, @RequestParam("comments") String comments){
		
		ticketsMngDao.rejectTickets("rejected", ticketId, comments);
	}
}
