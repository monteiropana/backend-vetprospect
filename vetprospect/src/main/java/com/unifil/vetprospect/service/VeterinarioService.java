package com.unifil.vetprospect.service;

import java.util.List;

import com.unifil.vetprospect.models.Veterinario;

public interface VeterinarioService {
	List<Veterinario> getVeterinarios();
	String adicionarVeterinario(Veterinario veterinario);
}