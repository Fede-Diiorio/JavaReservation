package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.RoleResDTO;
import com.coderhouse.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<RoleResDTO>> getAllRoles() {
		List<RoleResDTO> roles = roleService.getAll();
		return ResponseEntity.ok(roles);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RoleResDTO> getRoleById(@PathVariable Long id) {
		RoleResDTO role = roleService.getById(id);
		return ResponseEntity.ok(role);
	}
}
