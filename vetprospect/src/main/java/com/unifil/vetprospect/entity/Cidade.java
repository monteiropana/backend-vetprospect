package com.unifil.vetprospect.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unifil.vetprospect.models.request.CidadeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
@Table(name = "cidade")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonProperty("nome")
	@Column
	private String nome;

	@JsonProperty("estado")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_estado", foreignKey = @ForeignKey(name = "fk_estado"))
	private Estado estado;

	public Cidade(CidadeRequestDTO cidadeDto) {
		this.nome = cidadeDto.getNome();
		this.estado = Estado.builder().uf(cidadeDto.getUf()).build();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
