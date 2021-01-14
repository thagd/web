package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

public interface ILocacaoService {
	List<Locacao> buscarTodosClienteById(Long id);
	List<Locacao> buscarTodosLocadoraById(Long id);
	Locacao buscarPorId(Long id);
	List<Locacao> buscarTodos();
	void salvar(Locacao locacao);
	boolean verificaLocacao(Cliente cliente, Locadora locadora, String horario, String data);
}