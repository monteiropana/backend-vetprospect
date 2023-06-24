package com.unifil.vetprospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.entity.Estado;
import com.unifil.vetprospect.models.request.EstadoRequestDTO;
import com.unifil.vetprospect.service.EstadoService;

@RestController
@RequestMapping("/api/v1/config")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/estados")
	public ResponseEntity<List<Estado>> getEstados() {
		return new ResponseEntity<>(estadoService.getEstados(), HttpStatus.OK);
	}
	
	@PostMapping("/estado")
	public ResponseEntity<Object> insertEstado(@RequestBody EstadoRequestDTO estadoDto) {
		try {
			return new ResponseEntity<>(estadoService.insertEstado(estadoDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);			
		}
	}
}
