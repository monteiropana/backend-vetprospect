package com.unifil.vetprospect.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifil.vetprospect.entity.Endereco;
import com.unifil.vetprospect.models.response.EnderecoResponse;
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

	@Override
	public EnderecoResponse obterEnderecoPorCEP(String cep) throws Exception {
		URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		int statusCode = con.getResponseCode();
		
		EnderecoResponse response;
		StringBuffer content = new StringBuffer();
		
		if (200 == statusCode) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
			
			response = new ObjectMapper().readValue(content.toString(), EnderecoResponse.class);
		} else {
			con.disconnect();
			throw new Exception("CEP não encontrado");
		}		
		con.disconnect();
		
		return response;
	}
}