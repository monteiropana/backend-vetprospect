package com.unifil.vetprospect.models.request;

import java.util.UUID;

//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
	
	private UUID id;
	private String nome;
	private String cpfCnpj;
	private String senha;
	private String email;
	private String crmv;
	private String observacoes;
	private String especialidades;
	private EnderecoRequestDTO endereco;
	
}
