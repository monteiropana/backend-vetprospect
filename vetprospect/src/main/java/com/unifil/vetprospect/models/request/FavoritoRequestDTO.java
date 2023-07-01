package com.unifil.vetprospect.models.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoritoRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteRequestDTO vet;
}
