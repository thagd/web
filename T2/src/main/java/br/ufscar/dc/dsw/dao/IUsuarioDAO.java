package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	List<Usuario> findAll();
	Usuario findById(long id);
	Usuario save (Usuario usuario);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	public Usuario getUserByUsername(@Param("email") String email);
	
	@Query("SELECT l FROM Usuario l where l.role = :role") 
	List<Usuario> findAllRole(@Param("role") String role);
	
	@Query("SELECT l FROM Usuario l where l.role = ROLE_LOCADORA AND l.cidade = :cidade") 
    List<Usuario> findAllCidade(@Param("cidade") String cidade);
}