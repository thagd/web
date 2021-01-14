package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = { "senha", "role" })
@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {    
    @NotBlank(message = "{NotBlank.usuario.cpf}")
	@Column(length = 14)
    private String cpf;
    
    @NotBlank(message = "{NotBlank.usuario.nascimento}")
	@Column(length = 10)
    private String nascimento;
    
    @NotBlank(message = "{NotBlank.usuario.telefone}")
	@Column(length = 14)
    private String telefone;
    
    @NotBlank(message = "{NotBlank.usuario.sexo}")
	@Column(length = 10)
	private String sexo;
    
    public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
    }
    
    public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
    }
    
    public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
    }
    
    public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}