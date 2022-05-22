package com.unifil.vetprospect.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.models.Endereco;
import com.unifil.vetprospect.repository.EnderecoRepository;
import com.unifil.vetprospect.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Override
	public Endereco getEnderecoById(Long id) {
		return enderecoRepository.findById(id).orElse(null);
	}

}
