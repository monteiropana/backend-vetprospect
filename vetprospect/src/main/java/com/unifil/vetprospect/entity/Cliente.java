package com.unifil.vetprospect.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cliente")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter private UUID id;
	
	@Column(nullable = false, unique = true)
	@Setter private String email;
	
	@Column(nullable = false)
	@Setter private String senha;
	
	@Column(name = "cpf_cnpj", nullable = false, unique = true)
	@Getter @Setter private String cpfCnpj;
	
	@Column(nullable = false)
	@Getter @Setter private String nome;
	
	@Column()
	@Getter @Setter private String telefone;
	
	@Column(nullable = true, unique = true)
	@Getter @Setter private String crmv;
	
	@Column(nullable = true)
	@Getter @Setter private String observacoes;
	
	@Column(nullable = true)
	@Getter @Setter private String especialidades;
	
	@Column(nullable = true)
	@Getter @Setter private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "_endereco", foreignKey = @ForeignKey(name = "fk_endereco"))
	@Getter @Setter private Endereco endereco;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter private Role role;
	
	@PrePersist
	private void setup() {
		this.createdAt = LocalDateTime.now();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEnderecoFormatado() {
		StringBuilder str = new StringBuilder();
		str.append(this.endereco.getLogradouro()).append(", ").append(this.endereco.getNumero()).append(", ")
			.append(this.endereco.getBairro()).append(", ").append(this.endereco.getComplemento()).append(", ")
			.append(this.endereco.getCep()).append(", ").append(this.endereco.getCidade().getNome()).append(", ")
			.append(this.endereco.getCidade().getEstado().getUf());
		
		return str.toString();
	}
}
