package com.bcj.helpdesk.service.tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcj.helpdesk.dao.tickets.TicketsDao;
import com.bcj.helpdesk.model.tickets.Tickets;

/**
 * @author Harsha Kocherla
 * 
 *         This is a Service class which contains all the business logic related
 *         to Tickets, like saving the newly created ticket details to the data
 *         base.
 * 
 *         retrieveTicketsData for the student or consultant view.
 * 
 *         A method to generate Ticket Number.
 * 
 * 
 */

@Service
public class TicketsService {

	@Autowired
	TicketsDao ticketsDao;

	/**
	 * @param tickets
	 * @param loginId
	 * @param username
	 * @return boolean
	 * 
	 *         This method calls the saveTickets method to save the ticket
	 *         details in the data base based on the login Id.
	 * 
	 */

	public boolean saveTicket(Tickets tickets, int loginId, String username) {

		if (ticketsDao.saveTicket(tickets, loginId, username)) {

			return true;

		} else {

			return false;

		}
	}

	/**
	 * @param loginId
	 * @return List<Tickets>
	 * 
	 *         This method returns the Tickets List for the student or
	 *         consultant view by calling the retrieveTicketsData() method of
	 *         the TicketsDao class.
	 * 
	 *         A List of Maps is returned by calling the method and this List of
	 *         Maps is made to a List of Tickets.
	 * 
	 */

	public List<Tickets> retrieveTicketsData(int loginId) {

		List<Tickets> tickets = new ArrayList<Tickets>();

		List<Map<String, Object>> ticketsList = ticketsDao.retrieveTicketsData(loginId);

		for (Map<String, Object> map : ticketsList) {

			Tickets ticketsObject = new Tickets();

			ticketsObject.setTicketId((Integer) map.get("ticketId"));
			ticketsObject.setCategory((String) map.get("category"));
			ticketsObject.setSubcategory((String) map.get("subcategory"));
			ticketsObject.setDescription((String) map.get("description"));
			ticketsObject.setStat((String) map.get("stat"));
			ticketsObject.setComments((String) map.get("comments"));
			ticketsObject.setTicketNumber((String) map.get("ticketNumber"));

			tickets.add(ticketsObject);

		}

		return tickets;

	}

	/**
	 * @return List<String>
	 * 
	 *         This method returns List of categories which is useful to
	 *         populate the form data for the create Tickets page.
	 * 
	 *         retrieveCategory() is called to retrieve the categories present
	 *         in the database.
	 * 
	 */

	public List<String> retrieveCategory() {
		return ticketsDao.retrieveCategory();
	}

	/**
	 * @param category
	 * @return List<String>
	 * 
	 *         This method returns List of subCategories which is useful to
	 *         populate the form data for the create Tickets page.
	 * 
	 *         retrieveSubCategory() is called to retrieve the sub categories
	 *         present in the database.
	 */

	public List<String> retrieveSubCategory(String category) {

		return ticketsDao.retrieveSubCategory(category);

	}

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * @param count
	 * @return String
	 * 
	 *         This method is used for generation of ticket number which is
	 *         unique for every method call.
	 * 
	 */

	public static String ticketNumber(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
