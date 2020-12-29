package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Locacao;

public interface ILocacaoService {
	List<Locacao> buscarTodosCliente(String cliente);
	List<Locacao> buscarTodosLocadora(String locadora);
	List<Locacao> buscarTodosClienteById(Long id);
	List<Locacao> buscarTodosLocadoraById(Long id);
	Locacao buscarPorId(Long id);
	List<Locacao> buscarTodos();
	void salvar(Locacao locacao);
	boolean verificaLocacao(String cliente, String locadora, String horario, String data);
}