package com.unifil.vetprospect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.response.EnderecoResponse;
import com.unifil.vetprospect.service.EnderecoService;

@RestController
@RequestMapping("/api/v1/config")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoResponse> gobterEnderecoPorCep(@PathVariable("cep") String cep) throws Exception {
		return new ResponseEntity<>(enderecoService.obterEnderecoPorCEP(cep), HttpStatus.OK);
	}
}
