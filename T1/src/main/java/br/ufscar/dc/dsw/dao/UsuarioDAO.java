package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.Usuario;
import br.ufscar.dc.dsw.Locadora;
import br.ufscar.dc.dsw.Locacao;

public class UsuarioDAO extends GenericDAO {

    public void insert(Usuario usuario) {    
        String sql = "INSERT INTO Usuario (nome, login, senha, papel) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);   
            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getPapel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void insertLocadora(Usuario usuario) {    
        String sql = "INSERT INTO Usuario (nome, login, senha, papel, cidade) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql); 
            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getPapel());
            statement.setString(5, usuario.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertLocacao(Locacao locacao) {    
        String sql = "INSERT INTO Locacao (cliente, locadora, data) VALUES (?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);    
            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCliente());
            statement.setString(2, locacao.getLocadora());
            statement.setString(3, locacao.getData());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> getAll() {   
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * from Usuario u";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Usuario usuario = new Usuario(id, nome, login, senha, papel);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }
    
    public List<Usuario> getAllClientes() {   
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * from Usuario u WHERE papel = 'CLIENTE' ";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Usuario usuario = new Usuario(id, nome, login, senha, papel);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }
    
    public List<Usuario> getAllLocadoras() {   
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * from Usuario u WHERE papel = 'LOCADORA'";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String cidade = resultSet.getString("cidade");
                Usuario usuario = new Usuario(id, nome, login, senha, papel, cidade);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public List<Locacao> getAllLocacoes(String cliente) {   
        List<Locacao> listaLocacoes = new ArrayList<>();
        String sql = "SELECT * from Locacao u WHERE cliente = ?";
        try {
             Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String locadora = resultSet.getString("locadora");
                String data = resultSet.getString("data");
                Locacao locacao = new Locacao(id, cliente, locadora, data);
                listaLocacoes.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }

    public List<Locacao> getAllLocacoesLocadora(String locadora) {   
        List<Locacao> listaLocacoes = new ArrayList<>();
        String sql = "SELECT * from Locacao u WHERE locadora = ?";
        try {
             Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, locadora);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String cliente = resultSet.getString("cliente");
                String data = resultSet.getString("data");
                Locacao locacao = new Locacao(id, cliente, locadora, data);
                listaLocacoes.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }
    
    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void deleteLocacao(Locacao locacao) {
        String sql = "DELETE FROM Locacao where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, locacao.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, login = ?, senha = ?, papel = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getPapel());
            statement.setLong(5, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateLocadora(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, login = ?, senha = ?, papel = ?, cidade = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getPapel());
            statement.setString(5, usuario.getCidade());
            statement.setLong(6, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLocacao(Locacao locacao) {
        String sql = "UPDATE Locacao SET cliente = ?, locadora = ?, data = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCliente());
            statement.setString(2, locacao.getLocadora());
            statement.setString(3, locacao.getData());
            statement.setLong(4, locacao.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Usuario getbyID(Long id) {
        Usuario usuario = null;
        String sql = "SELECT * from Usuario WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                usuario = new Usuario(id, nome, login, senha, papel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public Locacao getLocacaoByID(Long id) {
        Locacao locacao = null;
        String sql = "SELECT * from Locacao WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cliente = resultSet.getString("cliente");
                String locadora = resultSet.getString("locadora");
                String data = resultSet.getString("data");
                locacao = new Locacao(cliente, locadora, data);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
    
    public Usuario getbyIDLocadora(Long id) {
        Usuario usuario = null;
        String sql = "SELECT * from Usuario WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String cidade = resultSet.getString("cidade");
                usuario = new Usuario(id, nome, login, senha, papel, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public Usuario getbyLogin(String login) {
        Usuario usuario = null;
        String sql = "SELECT * from Usuario WHERE login = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                usuario = new Usuario(id, nome, login, senha, papel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public List<Usuario> getLocadoraByCidade(String cidade) {   
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * from Usuario WHERE cidade = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cidade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Usuario usuario = new Usuario(id, nome, login, senha, papel, cidade);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }
}