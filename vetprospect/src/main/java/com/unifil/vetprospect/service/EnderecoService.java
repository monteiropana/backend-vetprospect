package com.unifil.vetprospect.service;

import com.unifil.vetprospect.models.Endereco;

public interface EnderecoService {
	Endereco salvarEndereco(Endereco endereco);
	Endereco getEnderecoById(Long id);
}
