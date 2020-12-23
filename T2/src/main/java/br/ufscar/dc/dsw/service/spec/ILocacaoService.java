package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Locacao;

public interface ILocacaoService {
	List<Locacao> buscarTodos();
	void salvar(Locacao locacao);
}