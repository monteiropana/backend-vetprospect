package com.unifil.vetprospect.models.response;

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
	
	private String nome;
	@JsonProperty("cpf_cnpj")
	private String cpfCnpj;
	private String crmv;
	private String telefone;
	@JsonProperty("created_at")
	private String createdAt;
	private String especialidade;
	private String observacoes;
	private String endereco;
}
