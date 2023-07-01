package com.unifil.vetprospect.models.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse extends Response {
	
	private UUID id;
	private String nome;
	private String email;
	private String crmv;
	private String telefone;
	@JsonProperty("created_at")
	private String createdAt;
	private String especialidade;
	private String observacoes;
	private String endereco;
	private EnderecoEditResponse enderecoEdit;
}
