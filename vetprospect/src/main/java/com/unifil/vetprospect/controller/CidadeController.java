package com.unifil.vetprospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.Cidade;
import com.unifil.vetprospect.service.CidadeService;

@RestController
@RequestMapping("/api/v1")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cidades")
	public ResponseEntity<List<Cidade>> getCidades() {
		return new ResponseEntity<>(cidadeService.getCidades(), HttpStatus.OK);
	}
}
