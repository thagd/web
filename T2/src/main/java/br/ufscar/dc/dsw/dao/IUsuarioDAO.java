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

	@Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    public Usuario getUserByUsername(@Param("nome") String nome);
}