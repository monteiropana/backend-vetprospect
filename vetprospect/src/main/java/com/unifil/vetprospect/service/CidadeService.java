package com.unifil.vetprospect.service;

import java.util.List;

import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.models.request.CidadeRequestDTO;

public interface CidadeService {
	
	List<Cidade> getCidades();
	List<Cidade> getCidadesPorEstado(String uf);
	Cidade insertCidade(CidadeRequestDTO cidadeDto) throws Exception;
}
