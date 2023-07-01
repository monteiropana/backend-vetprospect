package com.unifil.vetprospect.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEditResponse extends Response {
	
	private String logradouro;
	private String cep;
	private String bairro;
	private String complemento;
	private String numero;
	private Integer cidade;
	private String uf;
}
