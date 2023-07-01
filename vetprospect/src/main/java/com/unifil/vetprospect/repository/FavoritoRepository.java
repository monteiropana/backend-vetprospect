package com.unifil.vetprospect.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, UUID>{
	
//	@Query("SELECT fav FROM Favorito fav WHERE fav.cliente.id =:cliente AND fav.veterinario.id =:veterinario")
	Favorito findByClienteAndVeterinario(Cliente cliente, Cliente veterinario);
	List<Favorito> findByCliente(Cliente cliente);
}
