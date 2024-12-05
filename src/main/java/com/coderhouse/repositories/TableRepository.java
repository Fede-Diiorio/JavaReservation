package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Table;

public interface TableRepository extends JpaRepository<Table, Long>{

}
