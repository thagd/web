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
@Table(name = "Locadora")
public class Locadora extends Usuario {
    @NotBlank(message = "{NotBlank.usuario.cidade}")
	@Column(length = 30)
    private String cidade;
    
    @NotBlank(message = "{NotBlank.usuario.cnpj}")
	@Column(length = 18)
    private String cnpj;

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
    }
    
    public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}