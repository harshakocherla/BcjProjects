package com.bcj.helpdesk.service.registerandlogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcj.helpdesk.dao.registerandlogin.UserDaoImpl;
import com.bcj.helpdesk.model.registerandlogin.Login;
import com.bcj.helpdesk.model.registerandlogin.User;


/**
 * @author Harsha Kocherla
 * 
 * This is a Service class for the RegistrationAndLogin functionality, which has all the business logic like 
 * storing the user details in data base when a new user is signed up.
 * 
 * This class also has a method to validate user when he tries to login.
 * 
 * 
 */


@Service
public class RegistrationAndLoginService {

	@Autowired
	private UserDaoImpl userdaoimpl;
	
	
	/**
	 * @param user
	 * @return String
	 * 
	 * This method calls the saveUser() method of UserDaoImpl to save the new user details in data base.
	 * when the user details are saved successfully then the method returns userType.
	 * 
	 * 
	 */
	
	
	public String saveUser(User user){
		
		if(userdaoimpl.saveUser(user) != null){
			
			return user.getUserType();
			
		}else{
			
			return null;
		}
	}
	
	
	
	/**
	 * @param login
	 * @return String
	 * 
	 * This method calls verifyUser() method of UserDaoImpl class to validate the login details 
	 * based on the details present in data base.
	 * 
	 * 
	 */
	
	
	public String verifyUser(Login login){
		
		if(userdaoimpl.verifyUser(login) != null){
			
			return userdaoimpl.verifyUser(login);
			
		}else{
			
			return null;
		}
	}
	
	
	/**
	 * @return List<String>
	 * 
	 * This method returns a List of Strings by calling retrieveStates() of UserDaoImpl class 
	 * 
	 */
	
	
	public List<String> retrieveStates(){
		
		return userdaoimpl.retrieveStates();
		
	}
	
	
	/**
	 * @return List<String>
	 * 
	 * This method returns a List of Strings by calling retrieveUserType() of UserDaoImpl class
	 * 
	 *  
	 */
	
	
	public List<String> retrieveUserType(){
		
		return userdaoimpl.retrieveUserType();
		
	}
}
