package com.unifil.vetprospect.service;

import com.unifil.vetprospect.entity.Endereco;
import com.unifil.vetprospect.models.response.EnderecoResponse;

public interface EnderecoService {
	Endereco salvarEndereco(Endereco endereco);
	Endereco getEnderecoById(Long id);
	EnderecoResponse obterEnderecoPorCEP(String cep) throws Exception;
}
