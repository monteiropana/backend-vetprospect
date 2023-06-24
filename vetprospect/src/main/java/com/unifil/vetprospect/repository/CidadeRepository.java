package com.unifil.vetprospect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifil.vetprospect.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	List<Cidade> findByEstadoUf(String uf);

}
