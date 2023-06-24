package com.unifil.vetprospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.models.request.CidadeRequestDTO;
import com.unifil.vetprospect.service.CidadeService;

@RestController
@RequestMapping("/api/v1/config")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cidades")
	public ResponseEntity<List<Cidade>> getCidades() {
		return new ResponseEntity<>(cidadeService.getCidades(), HttpStatus.OK);
	}
	
	@GetMapping("/cidades/{uf}")
	public ResponseEntity<List<Cidade>> getCidadesPorEstado(@PathVariable("uf") String uf) {
		return new ResponseEntity<>(cidadeService.getCidadesPorEstado(uf), HttpStatus.OK);
	}
	
	@PostMapping("/cidade")
	public ResponseEntity<Object> insertCidade(@RequestBody CidadeRequestDTO cidadeDto) {
		try {
			return new ResponseEntity<>(cidadeService.insertCidade(cidadeDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
