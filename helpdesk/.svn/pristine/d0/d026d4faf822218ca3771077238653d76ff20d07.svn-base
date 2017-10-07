package com.bcj.helpdesk.service.registerandlogin;

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

import com.bcj.helpdesk.model.registerandlogin.Login;
import com.bcj.helpdesk.model.registerandlogin.User;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationAndLoginServiceTest {

	
	@Mock
	RegistrationAndLoginService rlService;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveUser(){
		
		User user = new User();
		user.setFirstName("kocherla");
		
		String userType = "Employ";
		
		when(rlService.saveUser(user)).thenReturn(userType);
		Assert.assertEquals(userType,rlService.saveUser(user));
	}
	
	@Test
	public void verifyUser(){
		
		Login login = new Login();
		login.setLoginId(Mockito.anyInt());
		
		String userType = "Employ";
		
		when(rlService.verifyUser(login)).thenReturn(userType);
		Assert.assertEquals(userType,rlService.verifyUser(login));
	}
	
	@Test
	public void retrieveStates(){
		
		List<String> usState = new ArrayList<String>();
		usState.add("Texas");
		
		when(rlService.retrieveStates()).thenReturn(usState);
		Assert.assertEquals(usState, rlService.retrieveStates());
	}
	
	@Test
	public void retrieveUserType(){
		
		List<String> userType = new ArrayList<String>();
		userType.add("Texas");
		
		when(rlService.retrieveStates()).thenReturn(userType);
		Assert.assertEquals(userType, rlService.retrieveStates());
	}
}
