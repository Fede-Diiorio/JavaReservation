package com.coderhouse.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coderhouse.dtos.UserReqDTO;
import com.coderhouse.dtos.UserResDTO;
import com.coderhouse.models.Role;
import com.coderhouse.models.User;
import com.coderhouse.services.RoleService;

@Component
public class UserMapper {

	@Autowired
	private RoleService roleService;

	public User toUser(UserReqDTO user) {
		User newUser = new User();

		Role role = roleService.getRoleById(user.getRole());

		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setRole(role);

		return newUser;
	}

	public UserResDTO toDTO(User user) {

		return new UserResDTO(user.getId(), user.getName(), user.getEmail(), user.getRole().getName());

	}

}
