package com.unifil.vetprospect.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
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
	public List<FavoritoResponse> obterFavoritos(Cliente cliente) {
		return favoritoRepository.findByCliente(cliente).stream().map(fav -> {
			return FavoritoResponse.builder()
					.id(fav.getId())
					.favorito(UsuarioResponse.builder()
							.id(fav.getVeterinario().getId())
							.nome(fav.getVeterinario().getNome())
							.email(fav.getVeterinario().getUsername())
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
	public FavoritoResponse adicionarFavorito(FavoritoRequestDTO favoritoDto, Cliente cliente) throws Exception {
		Cliente veterinario = clienteRepository.findById(favoritoDto.getVet().getId()).orElse(null);
		if (null == veterinario) {
			throw new Exception("Veterinario nao encontrado");
		}
		Favorito optFavorito = favoritoRepository.findByClienteAndVeterinario(cliente, veterinario);
		
		if (null == optFavorito) {
			Favorito favorito = Favorito.builder()
					.cliente(cliente)
					.veterinario(veterinario)
					.build();
			favorito = favoritoRepository.save(favorito); 
			
			return FavoritoResponse.builder()
					.id(favorito.getId())
					.favorito(UsuarioResponse.builder()
							.id(favorito.getVeterinario().getId())
							.nome(favorito.getVeterinario().getNome())
							.crmv(favorito.getVeterinario().getCrmv())
							.createdAt(favorito.getVeterinario().getCreatedAt().format(CUSTOM_FORMATTER))
							.telefone(favorito.getVeterinario().getTelefone())
							.especialidade(favorito.getVeterinario().getEspecialidades())
							.observacoes(favorito.getVeterinario().getObservacoes())
							.endereco(favorito.getVeterinario().getEnderecoFormatado())
							.build())
					.build();
		}
		
		throw new Exception("veterinario ja favoritado");
	}
	
	@Override
	public String removeFavoritoById(UUID id) throws Exception {
		try {
			favoritoRepository.delete(Favorito.builder().id(id).build());
			return "favorito deletado";
		} catch (Exception e) {
			throw new Exception("erro ao deletar favorito " + e.getMessage());
		}
	}
	
	@Override
	public String removeFavoritoByVet(UUID vet, Cliente user) throws Exception {
		try {
			Favorito fav = favoritoRepository.findByClienteAndVeterinario(user, Cliente.builder().id(vet).build());
			if (null != fav) {
				favoritoRepository.delete(fav);		
			}
			return "favorito deletado";
		} catch (Exception e) {
			throw new Exception("erro ao deletar favorito " + e.getMessage());
		}
	}
	
	@Override
	public FavoritoResponse obterFavoritoById(UUID vet, Cliente user) {
		try {
			final Favorito favorito = favoritoRepository.findByClienteAndVeterinario(user, Cliente.builder().id(vet).build());
			
			if (null != favorito) {
				return FavoritoResponse.builder()
						.id(favorito.getId())
						.favorito(UsuarioResponse.builder()
								.id(favorito.getVeterinario().getId())
								.nome(favorito.getVeterinario().getNome())
								.crmv(favorito.getVeterinario().getCrmv())
								.createdAt(favorito.getVeterinario().getCreatedAt().format(CUSTOM_FORMATTER))
								.telefone(favorito.getVeterinario().getTelefone())
								.especialidade(favorito.getVeterinario().getEspecialidades())
								.observacoes(favorito.getVeterinario().getObservacoes())
								.endereco(favorito.getVeterinario().getEnderecoFormatado())
								.build())
						.build();
			} else {
				return null;
			}			
		} catch (Exception e) {
			return null;
		}
	}
}

