package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Locacao;

public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{
	List<Locacao> findAllLocacoesCliente(String cliente);
	List<Locacao> findAllLocacoesLocadora(String locadora);
	Locacao saveLocacao(Locacao locacao);
}
