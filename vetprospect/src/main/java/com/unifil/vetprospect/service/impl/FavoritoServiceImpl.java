package com.unifil.vetprospect.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Favorito;
import com.unifil.vetprospect.models.request.FavoritoRequestDTO;
import com.unifil.vetprospect.models.response.FavoritoResponse;
import com.unifil.vetprospect.models.response.UsuarioResponse;
import com.unifil.vetprospect.repository.ClienteRepository;
import com.unifil.vetprospect.repository.FavoritoRepository;
import com.unifil.vetprospect.service.FavoritoService;

@Service
public class FavoritoServiceImpl implements FavoritoService {
	
	@Autowired
	private FavoritoRepository favoritoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

	@Override
	public List<FavoritoResponse> obterFavoritos() {
		return favoritoRepository.findAll().stream().map(fav -> {
			return FavoritoResponse.builder()
					.id(fav.getId())
					.favorito(UsuarioResponse.builder()
							.nome(fav.getVeterinario().getNome())
							.cpfCnpj(fav.getVeterinario().getCpfCnpj())
							.crmv(fav.getVeterinario().getCrmv())
							.createdAt(fav.getVeterinario().getCreatedAt().format(CUSTOM_FORMATTER))
							.telefone(fav.getVeterinario().getTelefone())
							.especialidade(fav.getVeterinario().getEspecialidades())
							.observacoes(fav.getVeterinario().getObservacoes())
							.endereco(fav.getVeterinario().getEnderecoFormatado())
							.build())
					.build();
		}).collect(Collectors.toList());
	}

	@Override
	public Favorito insertFavorito(FavoritoRequestDTO favoritoDto, Cliente cliente) throws Exception {
		Cliente veterinario = clienteRepository.findById(favoritoDto.getVet().getId()).orElse(null);
		if (null == veterinario) {
			throw new Exception("Veterinario nao encontrado");
		}
		Optional<Favorito> optFavorito = favoritoRepository.findByClienteAndVeterinario(cliente, veterinario);
		
		if (optFavorito.isEmpty()) {
			Favorito favorito = Favorito.builder()
					.cliente(cliente)
					.veterinario(veterinario)
					.build();
			
			return favoritoRepository.save(favorito);
		}
		
		throw new Exception("veterinario ja favoritado");
	}
	
	@Override
	public String removeFavorito(UUID id) throws Exception {
		try {
			favoritoRepository.delete(Favorito.builder().id(id).build());
			return "favorito deletado";
		} catch (Exception e) {
			throw new Exception("erro ao deletar favorito " + e.getMessage());
		}
	}

}

