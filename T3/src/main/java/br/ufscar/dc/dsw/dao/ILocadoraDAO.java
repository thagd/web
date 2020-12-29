package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, Long>{
	Locadora save (Locadora locadora);
	void deleteById(Long id);
	Locadora findById(long id);
	List<Locadora> findAll();
	
	@Query("SELECT l FROM Locadora l inner join Usuario p on (l.id = p.id) AND (l.cidade = :cidade)") 
	List<Locadora> findAllCity(@Param("cidade") String cidade);
	
	@Query("SELECT l FROM Locadora l inner join Locacao lc on (lc.locadora = :locadora)") 
    List<Locadora> verifyLocation(@Param("locadora") String locadora);
}