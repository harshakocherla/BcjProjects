package com.bcj.helpdesk.service.tickets;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.bcj.helpdesk.model.tickets.Tickets;

@RunWith(MockitoJUnitRunner.class)
public class TicketsServiceTest {

	@Mock
	private TicketsService ticketsService;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveTicketTest(){
		
		Tickets tickets = new Tickets();
		
		tickets.setCategory("category");
		tickets.setComments("comments");
		tickets.setDescription("description");
		tickets.setLogin_loginId(1);
		tickets.setStat("stat");
		tickets.setSubcategory("subcategory");
		tickets.setTicketId(1);
		tickets.setTicketNumber("ticketNumber");
		tickets.setUsername("username");
		
		int loginId = 1;
		String username = "username";
		
		when(ticketsService.saveTicket(tickets, loginId, username)).thenReturn(true);
		Assert.assertEquals(true, ticketsService.saveTicket(tickets, loginId, username));
	}
	
	@Test
	public void retrieveTicketsDataTest(){
		
		List<Tickets> list=new ArrayList<Tickets>();
		Tickets ticket=new Tickets();
		ticket.setCategory("Employement");
		list.add(ticket);
		
		
		when(ticketsService.retrieveTicketsData(Mockito.anyInt())).thenReturn(list);
		Assert.assertEquals(list, ticketsService.retrieveTicketsData(Mockito.anyInt()));
	}
	
	
	@Test
	public void retrieveCategoryTest(){
		List<String> category = new ArrayList<String>();
		
		category.add("Employment");
		category.add("Recruting");
		category.add("OfficeSupplies");
		category.add("Training");
		when(ticketsService.retrieveCategory()).thenReturn(category);
		
		List<String> testCategory = new ArrayList<String>();
		
		testCategory.add("Employment");
		testCategory.add("Recruting");
		testCategory.add("OfficeSupplies");
		testCategory.add("Training");
		Assert.assertEquals(testCategory, ticketsService.retrieveCategory());
	}
	
	@Test
	public void retrieveSubCategoryTest(){
		String category = "category";
		List<String> subCategory = new ArrayList<String>();
		
		subCategory.add("Offer Letter");
		subCategory.add("Pay Scale");
		subCategory.add("Phone Call");
		subCategory.add("Skype");
		when(ticketsService.retrieveSubCategory(category)).thenReturn(subCategory);
		
		List<String> testSubCategory = new ArrayList<String>();
		
		testSubCategory.add("Offer Letter");
		testSubCategory.add("Pay Scale");
		testSubCategory.add("Phone Call");
		testSubCategory.add("Skype");
		Assert.assertEquals(testSubCategory, ticketsService.retrieveSubCategory(category));
	}
	
/*	@Test
	public void ticketNumber(){
		int count = 6;
		String ticketNumber = "AI89U3";
		
		
		when(TicketsService.ticketNumber(count)).thenReturn(ticketNumber);
		Assert.assertEquals(ticketNumber, TicketsService.ticketNumber(count));
	}*/
}
