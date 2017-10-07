package com.bcj.helpdesk.dao.ticketsmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bcj.helpdesk.model.tickets.Tickets;



/**
 * @author Harsha Kocherla
 * 
 * This is a DAO class related to Tickets Management which has the connections with the Data Base to collect the required information from the database 
 * using JdbcTemplate.
 */


@Repository
public class TicketsManagementDao {
	
	
@Autowired
JdbcTemplate jdbcTemplate;


/**
 * @return
 * 
 * A query to retrieve all the data from tickets table of the data base is written for the 
 * employ view purpose.
 */


public List<Tickets> retrieveTicketsData() {
	
	String query = "select * from tickets";
	
	List<Tickets> tickets = jdbcTemplate.query(query, new BeanPropertyRowMapper<Tickets>(Tickets.class));
	
	return tickets;
	
}


/**
 * @param stat
 * @param ticketId
 * @param comments
 * 
 * A query is written to update the tickets table and modify the stat and comments columns of the table 
 * for a given ticketId.
 *  
 */


public void approveTickets(String stat, int ticketId, String comments) {
	String query = "update tickets set stat=?, comments=? where ticketId=?";
	jdbcTemplate.update(query, new Object[]{stat, comments, ticketId});
}



/**
 * @param stat
 * @param ticketId
 * @param comments
 * 
 * A query is written to update the tickets table and modify the stat and comments columns of the table 
 * for a given ticketId.
 * 
 * 
 */


public void rejectTickets(String stat, int ticketId, String comments) {
	
	String query = "update tickets set stat=?, comments=? where ticketId=?";
	jdbcTemplate.update(query, new Object[]{stat, comments, ticketId});
	
}

}
