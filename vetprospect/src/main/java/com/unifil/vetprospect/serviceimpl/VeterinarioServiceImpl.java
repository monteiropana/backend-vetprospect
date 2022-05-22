package com.unifil.vetprospect.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.models.Endereco;
import com.unifil.vetprospect.models.Veterinario;
import com.unifil.vetprospect.repository.VeterinarioRepository;
import com.unifil.vetprospect.service.EnderecoService;
import com.unifil.vetprospect.service.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	

	@Override
	public List<Veterinario> getVeterinarios() {
		return veterinarioRepository.findAll();
	}
	
	@Override
	public Veterinario getVeterinarioById(Long id) {
		return veterinarioRepository.findById(id).orElse(null);
	}

	@Override
	public Veterinario adicionarVeterinario(Veterinario veterinario) {
		Endereco endereco = enderecoService.salvarEndereco(veterinario.getEndereco());
		veterinario.setEndereco(endereco);
		return veterinarioRepository.save(veterinario);
	}
	
	@Override
	public Veterinario alterarVeterinario(Veterinario veterinario) {
		return veterinarioRepository.save(veterinario);
	}
}
