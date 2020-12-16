package br.ufscar.dc.dsw.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Locacao")
public class Locacao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String cliente;
	
	@Column(nullable = false, unique = true, length = 60)
	private String locadora;
	
	@Column(nullable = false, length = 10)
	private String data;
	
	@Column(nullable = false, length = 8)
	private String horario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getHorario() {
		return horario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}
	/*
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("Título: " + titulo + ", ");
		sb.append("Autor: " + autor + ", ");
		sb.append("Ano: " + ano + ", ");
		sb.append("Preço: " + preco + ", ");
		sb.append("Editora: " + editora);
		sb.append("]");
		return sb.toString();
	}*/
}
