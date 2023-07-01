package com.unifil.vetprospect.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Role;
import com.unifil.vetprospect.models.request.PartialClienteRequestDTO;
import com.unifil.vetprospect.models.response.EnderecoEditResponse;
import com.unifil.vetprospect.models.response.UsuarioResponse;
import com.unifil.vetprospect.repository.ClienteRepository;
import com.unifil.vetprospect.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HttpSession session;
	
	final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

	@Override
	public List<UsuarioResponse> getVeterinarios() throws Exception {
		List<Cliente> clientes = clienteRepository.findByRole(Role.VET).orElseThrow(() -> new Exception("Nenhum veterinário encontrado"));
		List<UsuarioResponse> veterinarios = clientes.stream()
				.map(vet -> this.buildCliente(vet))
				.collect(Collectors.toList());
		return veterinarios;
	}

	@Override
	public UsuarioResponse alterarDadosUser(UUID id, PartialClienteRequestDTO clienteDto) {
		Cliente cliente = (Cliente) this.session.getAttribute("cliente");
		
		if (null != cliente) {
			cliente.setNome(clienteDto.getNome());
			cliente.setEspecialidades(clienteDto.getEspecialidades());
			cliente.setObservacoes(clienteDto.getObservacoes());
			cliente.setTelefone(clienteDto.getTelefone());
			cliente.getEndereco().setCep(clienteDto.getEndereco().getCep());
			cliente.getEndereco().setBairro(clienteDto.getEndereco().getBairro());
			cliente.getEndereco().setCidade(Cidade.builder().id(clienteDto.getEndereco().getCidade()).build());
			cliente.getEndereco().setComplemento(clienteDto.getEndereco().getComplemento());
			cliente.getEndereco().setLogradouro(clienteDto.getEndereco().getLogradouro());
			cliente.getEndereco().setNumero(clienteDto.getEndereco().getNumero());
			
			cliente = clienteRepository.save(cliente);
			return this.buildCliente(cliente);
		}
		
		return null;
	}
	
	
	private UsuarioResponse buildCliente(Cliente cliente) {
		return UsuarioResponse
					.builder()
					.id(cliente.getId())
					.nome(cliente.getNome())
					.email(cliente.getUsername())
					.crmv(cliente.getCrmv())
					.createdAt(cliente.getCreatedAt().format(CUSTOM_FORMATTER))
					.telefone(cliente.getTelefone())
					.especialidade(cliente.getEspecialidades())
					.observacoes(cliente.getObservacoes())
					.endereco(cliente.getEnderecoFormatado())
					.build();
	}

	@Override
	public UsuarioResponse obterPorId(UUID id) {
		final Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if (null != cliente) {
			return UsuarioResponse
					.builder()
					.id(cliente.getId())
					.nome(cliente.getNome())
					.email(cliente.getUsername())
					.crmv(cliente.getCrmv())
					.createdAt(cliente.getCreatedAt().format(CUSTOM_FORMATTER))
					.telefone(cliente.getTelefone())
					.especialidade(cliente.getEspecialidades())
					.observacoes(cliente.getObservacoes())
					.enderecoEdit(EnderecoEditResponse.builder()
							.logradouro(cliente.getEndereco().getLogradouro())
							.bairro(cliente.getEndereco().getBairro())
							.cep(cliente.getEndereco().getCep())
							.complemento(cliente.getEndereco().getComplemento())
							.numero(cliente.getEndereco().getNumero())
							.cidade(cliente.getEndereco().getCidade().getId())
							.uf(cliente.getEndereco().getCidade().getEstado().getUf())
							.build())
					.build();
		}
		return null;
	}
	
}
