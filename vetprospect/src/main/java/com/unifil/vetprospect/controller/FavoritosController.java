package com.unifil.vetprospect.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.request.FavoritoRequestDTO;
import com.unifil.vetprospect.models.response.FavoritoResponse;
import com.unifil.vetprospect.service.FavoritoService;

@RestController
@RequestMapping("/api/v1")
public class FavoritosController extends BaseController {
	
	@Autowired
	private FavoritoService favoritoService;
	
	@GetMapping("/favoritos")
	public ResponseEntity<List<FavoritoResponse>> obterFavoritos() throws Exception {
		return new ResponseEntity<>(favoritoService.obterFavoritos(getCliente()), HttpStatus.OK);
	}
	
	@GetMapping("/favorito/{id}")
	public ResponseEntity<FavoritoResponse> obterFavoritosByVet(@PathVariable("id") UUID id) {
		return new ResponseEntity<>(favoritoService.obterFavoritoById(id, getCliente()), HttpStatus.OK);
	}
	
	@PostMapping("/favorito")
	public ResponseEntity<FavoritoResponse> adicionarFavorito(@RequestBody FavoritoRequestDTO favorito) throws Exception {
		return new ResponseEntity<>(favoritoService.adicionarFavorito(favorito, getCliente()), HttpStatus.OK);
	}
	
	@DeleteMapping("/favorito/{id}")
	public ResponseEntity<String> removerFavorito(@PathVariable("id") UUID id) throws Exception {
		return new ResponseEntity<>(favoritoService.removeFavoritoById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/favorito/vet/{id}")
	public ResponseEntity<String> removerFavoritoByVet(@PathVariable("id") UUID id) throws Exception {
		return new ResponseEntity<>(favoritoService.removeFavoritoByVet(id, getCliente()), HttpStatus.OK);
	}
}
