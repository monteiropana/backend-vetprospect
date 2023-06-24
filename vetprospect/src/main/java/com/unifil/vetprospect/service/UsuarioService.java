package com.unifil.vetprospect.service;

import java.util.List;

import com.unifil.vetprospect.models.response.UsuarioResponse;

public interface UsuarioService {
	
	List<UsuarioResponse> getVeterinarios() throws Exception;
}
