package com.unifil.vetprospect.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, UUID>{
	
	Optional<Favorito> findByClienteAndVeterinario(Cliente cliente, Cliente veterinario);
}
