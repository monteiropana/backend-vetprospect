package com.unifil.vetprospect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.unifil.vetprospect.entity.Cidade;
import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.entity.Endereco;
import com.unifil.vetprospect.entity.Estado;
import com.unifil.vetprospect.entity.Role;
import com.unifil.vetprospect.repository.CidadeRepository;
import com.unifil.vetprospect.repository.ClienteRepository;
import com.unifil.vetprospect.repository.EstadoRepository;

@SpringBootApplication
public class VetprospectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetprospectApplication.class, args);
	}

//	metodo apenas para exemplo para carregar o banco no inicio do desenvolvimento
	@Bean //anotacao que diz que o spring gerencia todo o ciclo de vida
	CommandLineRunner initDatabase(EstadoRepository estadoRepo, CidadeRepository cidadeRepo, ClienteRepository clienteRepo, PasswordEncoder encoder) { //metodo que sera executado assim que o projeto for inicializado
		return args -> {
			final List<Estado> estados = new ArrayList<Estado>() {{
				add(Estado.builder().uf("SP").nome("Sao Paulo").build());
				add(Estado.builder().uf("PR").nome("Parana").build());
				add(Estado.builder().uf("SC").nome("Santa Catarina").build());
				add(Estado.builder().uf("RJ").nome("Rio de Janeiro").build());
			}};
			
			final List<Cidade> cidades = new ArrayList<Cidade>() {{
				add(Cidade.builder().nome("Sao Paulo").estado(estados.get(0)).build());
				add(Cidade.builder().nome("Osasco").estado(estados.get(0)).build());
				add(Cidade.builder().nome("Londrina").estado(estados.get(1)).build());
				add(Cidade.builder().nome("Maringa").estado(estados.get(1)).build());
				add(Cidade.builder().nome("Florianopolis").estado(estados.get(2)).build());
				add(Cidade.builder().nome("Bombinhas").estado(estados.get(2)).build());
				add(Cidade.builder().nome("Rio de Janeiro").estado(estados.get(3)).build());
				add(Cidade.builder().nome("Angra dos Reis").estado(estados.get(3)).build());
			}};
			
			final List<Cliente> veterinarios = new ArrayList<Cliente>() {{;
				add(Cliente.builder()
					.nome("Valdir Toledo")
					.cpfCnpj("12345678901")
					.crmv("1234")
					.email("vet1@email.com")
					.senha(encoder.encode("123456"))
					.especialidades("Animais de Grande Porte")
					.endereco(Endereco.builder().logradouro("Avenida das Flores").bairro("Gleba").cep("86061312").numero("123").cidade(Cidade.builder().id(3).build()).build())
					.observacoes("Atendimento a domicilio gratis")
					.role(Role.VET)
					.build());
				add(Cliente.builder()
						.nome("Roberta Alencar")
						.cpfCnpj("12345678902")
						.crmv("1235")
						.email("vet2@email.com")
						.senha(encoder.encode("123456"))
						.especialidades("Animais Domesticos")
						.telefone("4300998877")
						.endereco(Endereco.builder().logradouro("Rua maria de jesus").bairro("Gleba").cep("86061312").numero("124").cidade(Cidade.builder().id(3).build()).build())
						.observacoes("Nao atende domicilio")
						.role(Role.VET)
						.build());
				add(Cliente.builder()
						.nome("Jorge Junqueira")
						.cpfCnpj("12345678903")
						.crmv("1236")
						.email("vet3@email.com")
						.senha(encoder.encode("123456"))
						.telefone("4300998877")
						.especialidades("Cirurgiao")
						.endereco(Endereco.builder().logradouro("Rua maria de jesus").bairro("Gleba").cep("86061312").numero("125").complemento("sala 7").cidade(Cidade.builder().id(3).build()).build())
						.observacoes("Internacao gratis")
						.role(Role.VET)
						.build());
				add(Cliente.builder()
						.nome("Ana Paula")
						.cpfCnpj("12345678905")
						.email("ana@email.com")
						.telefone("4300998877")
						.senha(encoder.encode("123456"))
						.endereco(Endereco.builder().logradouro("Rua maria de jesus").bairro("Gleba").cep("86061312").numero("75").cidade(Cidade.builder().id(3).build()).build())
						.role(Role.CLIENTE)
						.build());
			}};
			estadoRepo.saveAllAndFlush(estados);
			cidadeRepo.saveAllAndFlush(cidades);
			clienteRepo.saveAll(veterinarios);
		};
	}
}
