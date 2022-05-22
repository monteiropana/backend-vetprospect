package com.unifil.vetprospect.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.models.Cidade;
import com.unifil.vetprospect.repository.CidadeRepository;
import com.unifil.vetprospect.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public List<Cidade> getCidades() {
		return cidadeRepository.findAll();
	}

}
