package com.unifil.vetprospect.service;

import java.util.List;
import java.util.UUID;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Favorito;
import com.unifil.vetprospect.models.request.FavoritoRequestDTO;
import com.unifil.vetprospect.models.response.FavoritoResponse;

public interface FavoritoService {
	List<FavoritoResponse> obterFavoritos();
	Favorito insertFavorito(FavoritoRequestDTO favoritoDto, Cliente cliente)  throws Exception;
	String removeFavorito(UUID id) throws Exception;
}
