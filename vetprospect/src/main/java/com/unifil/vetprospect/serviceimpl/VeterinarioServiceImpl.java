package com.unifil.vetprospect.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.Veterinario;
import com.unifil.vetprospect.repository.VeterinarioRepository;
import com.unifil.vetprospect.service.VeterinarioService;

@RestController //anota essa classe como um servlet para o spring
@RequestMapping("/api/v1") //endereco base do nosso endpoint
public class VeterinarioServiceImpl implements VeterinarioService {
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;

	@Override
	@GetMapping("/veterinarios")
	public List<Veterinario> getVeterinarios() {
		return veterinarioRepository.findAll();
	}

	@Override
	public String adicionarVeterinario(@RequestBody Veterinario veterinario) {
		// TODO Auto-generated method stub
		return null;
	}
}
