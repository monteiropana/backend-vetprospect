package com.unifil.vetprospect.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
@Table(name = "estado")
@EqualsAndHashCode(of = {"uf"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("uf")
	@Getter @Setter private String uf;
	
	@JsonProperty("nome")
	@Column(length = 100, nullable = false)
	@Getter @Setter private String nome;

}
