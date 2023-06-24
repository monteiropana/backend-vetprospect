package com.unifil.vetprospect.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	
	@JsonProperty("mensagem")
	private String mensagem;
	
	@JsonProperty("status_code")
	private int statusCode;

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public Response setup(String mensagem, int statusCode) {
		this.mensagem = mensagem;
		this.statusCode = statusCode;
		return this;
	}
}
