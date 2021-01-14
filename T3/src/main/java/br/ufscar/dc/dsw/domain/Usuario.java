package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity<Long> {
	@NotBlank(message = "{NotBlank.usuario.nome}")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@NotBlank(message = "{NotBlank.usuario.email}")
	@Column(nullable = false, unique = true, length = 60)
	private String email;
	
	@NotBlank(message = "{NotBlank.usuario.senha}")
	@Column(nullable = false, length = 60)
	private String senha;
	
    @Column(nullable = false, length = 20)
    private String role;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String password) {
		this.senha = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
