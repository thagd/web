package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Locacao")
public class Locacao extends AbstractEntity<Long> {	
	@Column(nullable = false, length = 60)
	private String cliente;
	
	@Column(nullable = false, unique = true, length = 60)
	private String locadora;
	
	@Column(nullable = false, length = 10)
	private String data;
	
	@Column(nullable = false, length = 8)
	private String horario;

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setLocadora(String locadora) {
		this.locadora = locadora;
	}
	
	public String getLocadora() {
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
