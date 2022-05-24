package com.unifil.vetprospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.Veterinario;
import com.unifil.vetprospect.models.response.Response;
import com.unifil.vetprospect.service.VeterinarioService;

@RestController
@RequestMapping("/api/v1")
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService veterinarioService;

	@GetMapping("/veterinarios")
	public ResponseEntity<List<Veterinario>> listarVeterinarios() {
		return new ResponseEntity<>(veterinarioService.getVeterinarios(), HttpStatus.OK);
	}
	
	@GetMapping("/veterinario/{id}")
	public ResponseEntity<Veterinario> getVeterinario(@PathVariable Long id) {
		Veterinario veterinario = veterinarioService.getVeterinarioById(id);
		return new ResponseEntity<>(veterinario, HttpStatus.OK);
	}
	
	@PostMapping("/veterinario")
	public ResponseEntity<Response> salvarVeterinario(@RequestBody Veterinario veterinario) {
		veterinario = veterinarioService.adicionarVeterinario(veterinario);
		if (veterinario.getId() != null) {
			return new ResponseEntity<>(new Response().setupMensagem("Veterinario cadastrado com sucesso!"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response().setupMensagem("Erro ao cadastrar veterinário"), HttpStatus.OK);
		}
	}
	
	@PatchMapping("/veterinario")
	public ResponseEntity<Response> alterarVeterinario(@RequestBody Veterinario veterinario) {
		veterinario = veterinarioService.alterarVeterinario(veterinario);
		return new ResponseEntity<>(new Response().setupMensagem("Veterinario alterado com sucesso!"), HttpStatus.OK);
	}
}
