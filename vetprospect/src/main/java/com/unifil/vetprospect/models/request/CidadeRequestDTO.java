package com.unifil.vetprospect.models.request;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class CidadeRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String nome;

	private String uf;

}
