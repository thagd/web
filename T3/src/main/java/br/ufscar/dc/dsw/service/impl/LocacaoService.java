package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Service
@Transactional(readOnly = false)
public class LocacaoService implements ILocacaoService {

	@Autowired
	ILocacaoDAO dao;
	
	public void salvar(Locacao locacao) {
		dao.save(locacao);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosCliente(String cliente) {
		return dao.findAllByCliente(cliente);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosLocadora(String locadora) {
		return dao.findAllByLocadora(locadora);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosClienteById(Long id) {
		return dao.findAllByClienteById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosLocadoraById(Long id) {
		return dao.findAllByLocadoraById(id.longValue());
	}

	@Transactional(readOnly = true)
	public Locacao buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
    
	@Transactional(readOnly = true)
	public List<Locacao> buscarTodos() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public boolean verificaLocacao(String cliente, String locadora, String horario, String data) {
		return !dao.verifyLocation(cliente, locadora, horario, data).isEmpty();
	}
}
