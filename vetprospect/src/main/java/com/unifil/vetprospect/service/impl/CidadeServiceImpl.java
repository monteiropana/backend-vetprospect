package com.unifil.vetprospect.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.entity.Estado;
import com.unifil.vetprospect.models.request.CidadeRequestDTO;
import com.unifil.vetprospect.repository.CidadeRepository;
import com.unifil.vetprospect.repository.EstadoRepository;
import com.unifil.vetprospect.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<Cidade> getCidades() {
		return cidadeRepository.findAll();
	}
	
	@Override
	public List<Cidade> getCidadesPorEstado(String uf) {
		return cidadeRepository.findByEstadoUf(uf);
	}

	@Override
	public Cidade insertCidade(CidadeRequestDTO cidadeDto) throws Exception {
		Optional<Estado> estado = estadoRepository.findById(cidadeDto.getUf());
		if (estado.isPresent()) {
			return cidadeRepository.save(new Cidade(cidadeDto));
		}
		throw new Exception("estado nao encontrado");
	}

}
