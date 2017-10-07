package com.bcj.helpdesk.service.ticketsmanagment;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.bcj.helpdesk.model.tickets.Tickets;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TicketsManagementServiceTest {
	
	@Mock
	private TicketsManagementService ticketsMngService;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retrieveApprovedTickets(){
		
		List<Tickets> tickets = new ArrayList<Tickets>();
		
		Tickets ticket = new Tickets();
		ticket.setCategory("Employment");
		
		tickets.add(ticket);
		
		when(ticketsMngService.retrieveApprovedTickets()).thenReturn(tickets);
		Assert.assertEquals(tickets, ticketsMngService.retrieveApprovedTickets());
		
	}
	
	@Test
	public void retrievePendingTickets(){
		
		List<Tickets> tickets = new ArrayList<Tickets>();
		
		Tickets ticket = new Tickets();
		ticket.setCategory("Employment");
		
		tickets.add(ticket);
		
		when(ticketsMngService.retrievePendingTickets()).thenReturn(tickets);
		Assert.assertEquals(tickets, ticketsMngService.retrievePendingTickets());
	}
	
	@Test
	public void retrieveRejectedTickets(){
		List<Tickets> tickets = new ArrayList<Tickets>();
		
		Tickets ticket = new Tickets();
		ticket.setCategory("Employment");
		
		tickets.add(ticket);
		
		when(ticketsMngService.retrieveRejectedTickets()).thenReturn(tickets);
		Assert.assertEquals(tickets, ticketsMngService.retrieveRejectedTickets());
	}

}
