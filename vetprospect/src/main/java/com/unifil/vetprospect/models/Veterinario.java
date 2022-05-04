package com.unifil.vetprospect.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 30, nullable = false)
	private String especialidade;
	
	@Column(length = 30, nullable = false)
	private int crmv;
	
	@Column(length = 30, nullable = false)
	private String cidade;
	
	@Column(length = 30, nullable = false)
	private String endereco;
	
	@Column(length = 12, nullable = false)
	private String telefone;
	
	@Column(length = 100, nullable = false)
	private String observacoes;
}