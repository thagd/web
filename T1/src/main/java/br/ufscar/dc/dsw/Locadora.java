package br.ufscar.dc.dsw;

import java.util.List;

public class Locadora{
	private long id;
	private String nome;
	private String cidade;
	private String email;
	private String senha;
	
	public Locadora(long id, String nome, String cidade, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.senha = senha;
	}
	
	public Locadora(String nome, String cidade, String email, String senha) {
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
}