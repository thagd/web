package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Cliente;

@SuppressWarnings("unchecked")
public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	Cliente save (Cliente cliente);
	void deleteById(Long id);
	Cliente findById(long id);
	List<Cliente> findAll();
}