package br.ufscar.dc.dsw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Endereco extends AbstractEntity<Long> {	
	@NotBlank(message = "{NotBlank.cidade.locadora}")
	private String cidade;

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return cidade;
	}
}
