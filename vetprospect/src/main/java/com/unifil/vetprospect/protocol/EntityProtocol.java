package com.unifil.vetprospect.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EntityProtocol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("body")
	private Object body;
	
	public <T> T getBodyAs(Class<T> targetClass) {
		try {
			return targetClass.cast(body);			
		} catch (ClassCastException e) {
			e.printStackTrace();
			throw new ClassCastException("Erro ao converter body");
		}
	}
}
