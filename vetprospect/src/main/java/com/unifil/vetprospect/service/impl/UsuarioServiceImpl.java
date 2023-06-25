package com.unifil.vetprospect.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Role;
import com.unifil.vetprospect.models.response.UsuarioResponse;
import com.unifil.vetprospect.repository.ClienteRepository;
import com.unifil.vetprospect.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

	@Override
	public List<UsuarioResponse> getVeterinarios() throws Exception {
		List<Cliente> clientes = clienteRepository.findByRole(Role.VET).orElseThrow(() -> new Exception("Nenhum veterinário encontrado"));
		List<UsuarioResponse> veterinarios = clientes.stream()
				.map(vet -> UsuarioResponse
								.builder()
								.id(vet.getId())
								.nome(vet.getNome())
								.email(vet.getUsername())
								.crmv(vet.getCrmv())
								.createdAt(vet.getCreatedAt().format(CUSTOM_FORMATTER))
								.telefone(vet.getTelefone())
								.especialidade(vet.getEspecialidades())
								.observacoes(vet.getObservacoes())
								.endereco(vet.getEnderecoFormatado())
								.build())
				.collect(Collectors.toList());
		return veterinarios;
	}
}
