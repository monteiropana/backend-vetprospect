package com.unifil.vetprospect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return clienteRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email nao encontrado"));
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
