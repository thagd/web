package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Locacao;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{
	Locacao save (Locacao locacao);

	@Query("SELECT l FROM Locacao l where l.cliente = :cliente") 
	List<Locacao> findAllByCliente(@Param("cliente") String cliente);
	
	@Query("SELECT l FROM Locacao l where l.locadora = :locadora") 
	List<Locacao> findAllByLocadora(@Param("locadora") String locadora);
	
	@Query("SELECT l FROM Locacao l where l.data = :data AND l.horario = :horario AND (l.cliente = :cliente OR l.locadora = :locadora)") 
    List<Locacao> verifyLocation(@Param("cliente") String cliente, @Param("locadora") String locadora, @Param("horario") String horario, @Param("data") String data);
}