package com.unifil.vetprospect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VetprospectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetprospectApplication.class, args);
	}

	//metodo apenas para exemplo para carregar o banco no inicio do desenvolvimento
	//@Bean //anotacao que diz que o spring gerencia todo o ciclo de vida
//	CommandLineRunner initDatabase(VeterinarioRepository veterinarioRepository) { //metodo que sera executado assim que o projeto for inicializado
//		return args -> {
//			veterinarioRepository.deleteAll();
//			List<Veterinario> veterinarios = new ArrayList<Veterinario>();
//			veterinarios.add(new Veterinario(1l, "Valdir", "Animais de Grande Porte", 12345, "Londrina", "Gleba", "99999999", "Observacoes"));
//			
//			veterinarioRepository.saveAll(veterinarios);
//		};
//	}
}
