package com.unifil.vetprospect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veterinario")
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("nome")
	@Column(length = 30, nullable = false)
	private String nome;
	
	@JsonProperty("especialidade")
	@Column(length = 30, nullable = false)
	private String especialidade;
	
	@JsonProperty("crmv")
	@Column(length = 30, nullable = false)
	private Integer crmv;
	
	@JsonProperty("endereco")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "_endereco", foreignKey = @ForeignKey(name = "fk_endereco"))
	private Endereco endereco;
	
	@JsonProperty("telefone")
	@Column(length = 12, nullable = false)
	private String telefone;
	
	@JsonProperty("observacoes")
	@Column(length = 100, nullable = false)
	private String observacoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Integer getCrmv() {
		return crmv;
	}

	public void setCrmv(Integer crmv) {
		this.crmv = crmv;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}
}