package com.unifil.vetprospect.service;

import java.util.List;

import com.unifil.vetprospect.entity.Estado;
import com.unifil.vetprospect.models.request.EstadoRequestDTO;

public interface EstadoService {
	List<Estado> getEstados();
	Estado insertEstado(EstadoRequestDTO estadoDto) throws Exception;
}
