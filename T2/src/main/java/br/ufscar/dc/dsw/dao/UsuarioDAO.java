package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import br.ufscar.dc.dsw.domain.Usuario;

public abstract class UsuarioDAO implements IUsuarioDAO{
	@Override
	public List<Usuario> findAllClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAllLocadoras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findLocadoraByCidade(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario saveCliente(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario saveLocadora(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLocadora(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCliente(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findClienteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findLocadoraById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findUsuariosByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
