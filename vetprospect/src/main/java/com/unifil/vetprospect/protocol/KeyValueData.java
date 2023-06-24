package com.unifil.vetprospect.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KeyValueData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("key")
	public String key;
	
	@JsonProperty("value")
	public String value;
}
