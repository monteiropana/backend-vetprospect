package com.unifil.vetprospect.models.request;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class FavoritoRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteRequestDTO vet;
}
