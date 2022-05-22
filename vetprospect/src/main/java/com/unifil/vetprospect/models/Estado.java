package com.unifil.vetprospect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
@Table(name = "estado")
@EqualsAndHashCode(of = {"uf"})
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("uf")
	@Id
	private String uf;
	
	@JsonProperty("nome")
	@Column(length = 100, nullable = false)
	private String nome;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
