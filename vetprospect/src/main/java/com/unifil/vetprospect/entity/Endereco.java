package com.unifil.vetprospect.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;

	@Column
	@Getter @Setter private String cep;
	
	@Column
	@Getter @Setter private String logradouro;
	
	@Column
	@Getter @Setter private String numero;
	
	@Column
	@Getter @Setter private String bairro;
	
	@Column
	@Getter @Setter private String complemento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "_cidade", foreignKey = @ForeignKey(name = "fk_cidade"))
	@Getter @Setter private Cidade cidade;

}
