package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Usuario;


public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	List<Usuario> findAllClientes();
	List<Usuario> findAllLocadoras();
	List<Usuario> findLocadoraByCidade(String cidade);
	Usuario saveCliente(Usuario usuario);
	Usuario saveLocadora(Usuario usuario);
	void deleteById(Long id);
	void updateLocadora(Usuario usuario);
	void updateCliente(Usuario usuario);
	Usuario findClienteById(long id);
	Usuario findLocadoraById(long id);
	Usuario findUsuariosByLogin(String login);
}