package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
