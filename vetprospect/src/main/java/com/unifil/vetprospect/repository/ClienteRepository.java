package com.unifil.vetprospect.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Role;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

	Optional<Cliente> findByEmail(String email);
	Optional<List<Cliente>> findByRole(Role role);
}
