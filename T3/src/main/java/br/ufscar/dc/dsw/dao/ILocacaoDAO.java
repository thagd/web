package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{
	Locacao save (Locacao locacao);
	Locacao findById(long id);
	List<Locacao> findAll();

	@Query("SELECT l FROM Locacao l where l.cliente.id = :id")
	List<Locacao> findAllByClienteById(@Param("id") long id);
	
	@Query("SELECT l FROM Locacao l where l.locadora.id = :id") 
	List<Locacao> findAllByLocadoraById(@Param("id") long id);
	
	@Query("SELECT l FROM Locacao l where l.data = :data AND l.horario = :horario AND (l.cliente = :cliente OR l.locadora = :locadora)") 
    List<Locacao> verifyLocation(@Param("cliente") Cliente cliente, @Param("locadora") Locadora locadora, @Param("horario") String horario, @Param("data") String data);
}