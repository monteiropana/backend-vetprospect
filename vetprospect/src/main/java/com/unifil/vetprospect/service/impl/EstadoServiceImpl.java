package com.unifil.vetprospect.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Estado;
import com.unifil.vetprospect.models.request.EstadoRequestDTO;
import com.unifil.vetprospect.repository.EstadoRepository;
import com.unifil.vetprospect.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<Estado> getEstados() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado insertEstado(EstadoRequestDTO estadoDto) throws Exception {
		Optional<Estado> optEstado = estadoRepository.findById(estadoDto.getUf());
		if (optEstado.isEmpty()) {
			Estado estado = Estado.builder()
					.uf(estadoDto.getUf())
					.nome(estadoDto.getNome())
					.build();
			return estadoRepository.save(estado);
		}
		throw new Exception("o estado " + estadoDto.getUf() + " já existe");
	}
}
