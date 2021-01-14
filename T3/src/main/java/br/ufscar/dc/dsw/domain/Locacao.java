package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;

@SuppressWarnings("serial")
@Entity
@Table(name = "Locacao")
public class Locacao extends AbstractEntity<Long> {	
	@Column(nullable = false, length = 500)
	private Cliente cliente;
	
	@NotNull(message = "{NotBlank.locacao.locadora}")
	@Column(nullable = false, length = 500)
	private Locadora locadora;
	
	@NotBlank(message = "{NotBlank.locacao.data}")
	@Column(nullable = false, length = 10)
	private String data;
	
	@NotBlank(message = "{NotBlank.locacao.horario}")
	@Column(nullable = false, length = 8)
	private String horario;

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	
	public Locadora getLocadora() {
		return locadora;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getHorario() {
		return horario;
	}
}
