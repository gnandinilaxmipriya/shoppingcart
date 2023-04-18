package com.shopcart.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shopcart.backend.model.Address;
import com.shopcart.backend.model.Users;
import com.shopcart.backend.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	public Users addnewUsers(Users users)
	{
		return usersRepository.save(users);
	}
	public List<Users> getAllUsers(){
		
		return usersRepository.findAll();
	}
	public String validateUser(Map<String,String> map) {
		String email = map.get("email");
		String password = map.get("password");
		List<Users> user = usersRepository.findByEmailAndPassword(email,password);
		if(user.isEmpty())
		{
			return "false";
		}else {
			return "true";
		}
	}
	public String getActiveUser(Map<String,String> map)
	{
		String email = map.get("email");
		List<Users> user = usersRepository.findByEmail(email);
		if(user.isEmpty())
		{
			
			return "false";
		}else {
			//already a user 
//			throw new UserEmailNotFoundException("Email Id exists");
			return "true";
		}
	}
	public List<Users> getProfile(String email){
		return usersRepository.findByEmail(email);
	}
	
	public String getUserId(String email) {
		List<Users> li = usersRepository.findByEmail(email);
		String id = li.get(0).getId().toString();
		return id;
	}
	public Users updatePassword(String email ,Users user)
	{
//		Users existingUsers = usersRepository.findById(id).get();
		Users existingUsers = usersRepository.findByEmail(email).get(0);
//		existingUsers.setUname(users.getUname());
//		existingUsers.setEmail(users.getEmail());
//		existingUsers.setPhone(users.getPhone());
//		existingUsers.setAddress(users.getAddress());
//		existingUsers.setEmail(user.getEmail());
		existingUsers.setPassword(user.getPassword());
		return usersRepository.save(existingUsers);

	}
	public Users updateProfile(String email,Users users) {
		Users existingUsers = usersRepository.findByEmail(email).get(0);
		
		existingUsers.setUname(users.getUname());
		existingUsers.setEmail(users.getEmail());
		existingUsers.setPhone(users.getPhone());
		
//		existingUsers.setEmail(users.getEmail());
//		existingUsers.setPassword(existingUsers.getPassword());
		
		Address address = users.getAddress();
//		address.setId(address.getId());
		address.setStreet(address.getStreet());
		address.setCity(address.getCity());
		address.setState(address.getState());
		address.setPincode(address.getPincode());
		
		existingUsers.setAddress(address);
		return usersRepository.save(existingUsers);
		
	}
}