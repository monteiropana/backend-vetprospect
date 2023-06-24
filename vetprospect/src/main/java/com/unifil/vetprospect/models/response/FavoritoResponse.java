package com.unifil.vetprospect.models.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritoResponse extends Response {
	
	private UUID id;
	private UsuarioResponse favorito;
}
