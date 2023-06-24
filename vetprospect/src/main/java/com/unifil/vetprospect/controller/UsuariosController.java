package com.unifil.vetprospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
