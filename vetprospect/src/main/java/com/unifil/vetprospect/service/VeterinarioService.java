package com.unifil.vetprospect.service;

import java.util.List;

import com.unifil.vetprospect.models.Veterinario;

public interface VeterinarioService {
	List<Veterinario> getVeterinarios();
	Veterinario getVeterinarioById(Long id);
	Veterinario adicionarVeterinario(Veterinario veterinario);
	Veterinario alterarVeterinario(Veterinario veterinario);
}