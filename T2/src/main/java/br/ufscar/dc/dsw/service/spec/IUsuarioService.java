package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Usuario;

public interface IUsuarioService {
	Usuario buscarPorId(Long id);
	List<Usuario> buscarTodos();
	List<Usuario> buscarTodosRole(String role);
	List<Usuario> buscarTodosCidade(String cidade);
	void salvar(Usuario usuario);
	void excluir(Long id);
}