package com.unifil.vetprospect.models.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartialClienteRequestDTO {
	
	private UUID id;
	private String nome;
	private String observacoes;
	private String especialidades;
	private String telefone;
	private EnderecoRequestDTO endereco;
	
}
