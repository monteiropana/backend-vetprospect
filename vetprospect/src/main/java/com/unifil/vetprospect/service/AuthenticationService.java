package com.unifil.vetprospect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.config.JwtService;
import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Endereco;
import com.unifil.vetprospect.entity.Role;
import com.unifil.vetprospect.models.request.AuthenticationRequest;
import com.unifil.vetprospect.models.request.ClienteRequestDTO;
import com.unifil.vetprospect.models.response.AuthenticationResponse;
import com.unifil.vetprospect.repository.CidadeRepository;
import com.unifil.vetprospect.repository.ClienteRepository;
import com.unifil.vetprospect.repository.EnderecoRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private final HttpSession httpSession;
	
	@Autowired
	private final ClienteRepository clienteRepository;
	private final PasswordEncoder encoder;
	
	@Autowired
	private final JwtService jwtService;
	@Autowired
	private final AuthenticationManager authManager;
	@Autowired
	private final CidadeRepository cidadeRepository;
	@Autowired
	private final EnderecoRepository enderecoRepository;
	
	public AuthenticationResponse register(ClienteRequestDTO clienteRequest) throws Exception {
		var cliente = buildCliente(clienteRequest);
		clienteRepository.save(cliente);
		return this.generateToken(cliente);
		
	}
	
	public Cliente buildCliente(ClienteRequestDTO clienteRequest) throws Exception {
		Cidade cidade = cidadeRepository.findById(clienteRequest.getEndereco().getCidade()).orElseThrow(() -> new Exception("Cidade nao encontrada"));
		var endereco = Endereco.builder()
				.logradouro(clienteRequest.getEndereco().getLogradouro())
				.bairro(clienteRequest.getEndereco().getBairro())
				.numero(clienteRequest.getEndereco().getNumero())
				.complemento(clienteRequest.getEndereco().getComplemento())
				.cidade(cidade)
				.build();
		endereco = enderecoRepository.saveAndFlush(endereco);
		
		var cliente = Cliente.builder()
				.nome(clienteRequest.getNome())
				.cpfCnpj(clienteRequest.getCpfCnpj())
				.email(clienteRequest.getEmail())
				.senha(encoder.encode(clienteRequest.getSenha()))
				.crmv(clienteRequest.getCrmv())
				.observacoes(clienteRequest.getObservacoes())
				.especialidades(clienteRequest.getEspecialidades())
				.endereco(endereco)
				.role(clienteRequest.getCrmv() == null || clienteRequest.getCrmv().isEmpty() ? Role.CLIENTE : Role.VET)
				.build();
		

		return cliente;
	}

	public AuthenticationResponse login(AuthenticationRequest authRequest) {
		authManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					authRequest.getEmail(), 
					authRequest.getSenha()
			)
		);
		var cliente = clienteRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
		return this.generateToken(cliente);
	}
	
	public AuthenticationResponse generateToken(Cliente cliente) {
		var token = jwtService.generateToken(cliente);
		return AuthenticationResponse.builder()
				.token(token)
				.id(cliente.getId())
				.nome(cliente.getNome())
				.role(cliente.getRole().toString())
				.build();
	}
	
	
}
