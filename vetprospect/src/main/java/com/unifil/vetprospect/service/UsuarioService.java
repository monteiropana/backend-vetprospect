package com.unifil.vetprospect.service;

import java.util.List;
import java.util.UUID;

import com.unifil.vetprospect.models.request.PartialClienteRequestDTO;
import com.unifil.vetprospect.models.response.UsuarioResponse;

public interface UsuarioService {
	
	List<UsuarioResponse> getVeterinarios() throws Exception;
	UsuarioResponse alterarDadosUser(UUID id, PartialClienteRequestDTO cliente);
	UsuarioResponse obterPorId(UUID id);
}
