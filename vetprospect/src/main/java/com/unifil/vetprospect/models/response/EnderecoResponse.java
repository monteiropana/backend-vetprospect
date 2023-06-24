package com.unifil.vetprospect.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoResponse {
	
	@JsonProperty("cep")
	private String cep;
	
	@JsonProperty("uf")
	private String uf;
	
	@JsonProperty("localidade")
	private String cidade;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("logradouro")
	private String logradouro;
}
