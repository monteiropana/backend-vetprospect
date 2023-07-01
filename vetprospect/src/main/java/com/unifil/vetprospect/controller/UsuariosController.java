package com.unifil.vetprospect.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.request.PartialClienteRequestDTO;
import com.unifil.vetprospect.models.response.UsuarioResponse;
import com.unifil.vetprospect.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/veterinarios")
	public ResponseEntity<List<UsuarioResponse>> obterVeterinarios() throws Exception {
		return new ResponseEntity<>(usuarioService.getVeterinarios(), HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioResponse> obterUsuarioPorId(@PathVariable("id") UUID id) {
		return new ResponseEntity<>(usuarioService.obterPorId(id), HttpStatus.OK);
	}
	
	@PatchMapping("/usuario/{id}")
	public ResponseEntity<UsuarioResponse> alterarDadosUser(@PathVariable("id") UUID id, @RequestBody PartialClienteRequestDTO cliente) {
		return new ResponseEntity<>(usuarioService.alterarDadosUser(id, cliente), HttpStatus.OK);
	}
}
