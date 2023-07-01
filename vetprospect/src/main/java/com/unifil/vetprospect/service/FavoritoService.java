package com.unifil.vetprospect.service;

import java.util.List;
import java.util.UUID;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.models.request.FavoritoRequestDTO;
import com.unifil.vetprospect.models.response.FavoritoResponse;

public interface FavoritoService {
	List<FavoritoResponse> obterFavoritos(Cliente cliente);
	FavoritoResponse adicionarFavorito(FavoritoRequestDTO favoritoDto, Cliente cliente)  throws Exception;
	String removeFavoritoById(UUID id) throws Exception;
	String removeFavoritoByVet(UUID vet, Cliente user) throws Exception;
	FavoritoResponse obterFavoritoById(UUID vet, Cliente cliente);
}
