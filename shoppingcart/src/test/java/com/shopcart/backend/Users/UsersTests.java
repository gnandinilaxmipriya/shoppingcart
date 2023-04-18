package com.shopcart.backend.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import java.util.*;  
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shopcart.backend.repository.UsersRepository;
import com.shopcart.backend.service.UsersService;
import com.shopcart.backend.model.*;
import static java.util.Arrays.asList;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UsersTests {
	
	@MockBean
	private UsersRepository usersRepository ;

	@InjectMocks
	private UsersService usersService; 
	
	@Test
	public void checkUserExists() {
		HashMap<String,String> map = new HashMap<String,String>();
		String email = "nandy@mail.com";
		String password ="444";
		map.put("email", email);
		map.put("password", password);
		Users user = new Users();
		user.setEmail(email);
		user.setPassword(password);
		Mockito.when(usersRepository.findByEmailAndPassword(email, password)).thenReturn(asList(user));
		String result = usersService.validateUser(map);
		assertEquals("true",result);
//		verify(usersRepository.findByEmailAndPassword(email, password));
	}
	
	@Test
	public void checkUserDoesntexists() {
		HashMap<String,String> map = new HashMap<String,String>();
		String email = "nandy@mail.com";
		String password ="444";
		map.put("email", email);
		map.put("password", "4445");
		Users user = new Users();
		user.setEmail(email);
		user.setPassword(password);
		Mockito.when(usersRepository.findByEmailAndPassword(email, password)).thenReturn(asList(user));
		String result = usersService.validateUser(map);
		assertEquals("false",result);
	}
	
	@Test
	public void getActiveUser() {
		HashMap<String,String> map = new HashMap<String,String>();
		String email = "nandy@mail.com";
		Users user = new Users();
		user.setEmail(email);
		map.put("email","nandy@mail.com");
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		String result = usersService.getActiveUser(map);
		assertEquals("true",result);
	}
	@Test
	public void getNotActiveUser() {
		HashMap<String,String> map = new HashMap<String,String>();
		String email = "nandy@mail.com";
		Users user = new Users();
		user.setEmail(email);
		map.put("email","nandypriya@mail.com");
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		String result = usersService.getActiveUser(map);
		assertEquals("false",result);
	}
	
	@Test
	public void getProfile() {
		String email = "nandy@mail.com";
		Users user = new Users();
		user.setEmail(email);
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		List<Users> users = usersService.getProfile("nandy@mail.com");
		assertEquals(user,users.get(0));
	}
	@Test
	public void getNotExistingProfile() {
		String email = "nandy@mail.com";
		Users user = new Users();
//		user.setEmail(email);
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		List<Users> users = usersService.getProfile("nandy2@mail.com");
		assertEquals(0,users.size());
	}
	
	@Test
	public void getUserId() {
		String email = "nandy@mail.com";
		Users user = new Users();
		user.setEmail(email);
		user.setId((long) 1);
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		String id = usersService.getProfile("nandy@mail.com").get(0).getId().toString();
		assertEquals(user.getId().toString(),id);
	}
	
	@Test
	public void getUserIdifnotexists() {
		String email = "nandy@mail.com";
		Users user = new Users();
		user.setEmail(email);
		user.setId((long) 1);
		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
		int size = usersService.getProfile("nandy2@mail.com").size();
		assertEquals(0,size);
	}
	
//	@Test
//	public void updatePassword() {
//		String email = "nandy@mail.com";
//		String password="333";
//		Users user = new Users();
//		user.setEmail(email);
//		user.setPassword(password);
//		
////		Users user1 = new Users();
////		
////		user.setPassword("444");
////		
//		
//		Mockito.when(usersRepository.findByEmail(email)).thenReturn(asList(user));
//		Users nuser = usersService.updatePassword(email, user);
//	
//		assertEquals(user,nuser);
//	}
}
