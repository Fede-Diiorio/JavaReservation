package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.RoleResDTO;
import com.coderhouse.mappers.RoleMapper;
import com.coderhouse.models.Role;
import com.coderhouse.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRpository;
	
	@Autowired 
	private RoleMapper roleMapper;
	
	public List<RoleResDTO> getAll() {
		List<Role> roles = roleRpository.findAll();
		return roles.stream().map(roleMapper::toDTO).toList();
	}
	
	public RoleResDTO getById(Long id) {
		Role role = getRoleById(id);
		return roleMapper.toDTO(role);
	}
	
	public Role getRoleById(Long id) {
		return roleRpository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("El rol de usuario no existe"));
	}
}
