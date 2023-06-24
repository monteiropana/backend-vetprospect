package com.unifil.vetprospect.models.request;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class EnderecoRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cep;

	private String logradouro;
	
	private String bairro;
	
	private String numero;
	
	private String complemento;
	
	private Integer cidade;
}
