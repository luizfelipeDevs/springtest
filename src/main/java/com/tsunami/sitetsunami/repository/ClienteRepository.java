package com.tsunami.sitetsunami.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsunami.sitetsunami.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findById(long id);
	
}
