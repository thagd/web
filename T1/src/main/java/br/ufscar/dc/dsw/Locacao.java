package br.ufscar.dc.dsw;

import java.util.List;

public class Locacao{
	private long id;
	private String cliente;
	private String locadora;
	private String data;
	
	public Locacao(long id, String cliente, String locadora, String data) {
		this.id = id;
		this.cliente = cliente;
		this.locadora = locadora;
        this.data = data;
	}
	
	public Locacao(String cliente, String locadora, String data) {
		this.cliente = cliente;
		this.locadora = locadora;
		this.data = data;
	}

	public Locacao(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
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
}