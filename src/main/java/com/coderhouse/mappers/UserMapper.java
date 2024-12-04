package com.coderhouse.mappers;

import org.springframework.stereotype.Component;

import com.coderhouse.dtos.UserReqDTO;
import com.coderhouse.dtos.UserResDTO;
import com.coderhouse.models.User;

@Component
public class UserMapper {

	public User toUser(UserReqDTO user) {
		User newUser = new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setPhone(user.getPhone());
		
		return newUser;
	}
	
	public UserResDTO toDTO(User user) {
		return new UserResDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
	}
	
}
