package com.unifil.vetprospect.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	
	@JsonProperty("mensagem")
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Response setupMensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}
}
