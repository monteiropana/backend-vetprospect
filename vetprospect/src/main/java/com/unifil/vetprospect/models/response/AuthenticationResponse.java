package com.unifil.vetprospect.models.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	private String nome;
	private String role;
}
