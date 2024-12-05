package com.coderhouse.mappers;

import org.springframework.stereotype.Component;

import com.coderhouse.dtos.RoleResDTO;
import com.coderhouse.models.Role;

@Component
public class RoleMapper {

	public RoleResDTO toDTO(Role role) {
		return new RoleResDTO(role.getId(), role.getName());
	}
}
