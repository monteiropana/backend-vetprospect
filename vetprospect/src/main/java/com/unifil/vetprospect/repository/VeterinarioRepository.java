package com.unifil.vetprospect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifil.vetprospect.models.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

}