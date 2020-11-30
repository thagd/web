package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.Locadora;

public class LocadoraDAO extends GenericDAO {

    public void insert(Locadora locadora) {    
        String sql = "INSERT INTO Locadora (nome, cidade, email, senha) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getNome());
            statement.setString(4, locadora.getCidade());
            statement.setString(2, locadora.getEmail());
            statement.setString(3, locadora.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Locadora> getAll() {   
        List<Locadora> listaLocadoras = new ArrayList<>();
        String sql = "SELECT * FROM Locadora l ORDER BY l.nome";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Locadora locadora = new Locadora(id, nome, cidade, email, senha);
                listaLocadoras.add(locadora);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }
    
    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, locadora.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET nome = ?, cidade = ?, email = ?, senha = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getNome());
            statement.setString(2, locadora.getCidade());
            statement.setString(3, locadora.getEmail());
            statement.setString(4, locadora.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Locadora getbyID(Long id) {
    	Locadora locadora = null;
        String sql = "SELECT * from Locadora WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                locadora = new Locadora(id, nome, cidade, email, senha);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    
    public Locadora getbyLogin(String login) {
    	Locadora locadora = null;
        String sql = "SELECT * from Locadora WHERE login = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                locadora = new Locadora(id, nome, cidade, email, senha);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    
    public List<Locadora> getbyCidade(String cidade) {
    	List<Locadora> listaLocadoras = new ArrayList<>();
        String sql = "SELECT * from Locadora WHERE cidade = ? ORDER BY nome";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cidade);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Locadora locadora = new Locadora(id, nome, email, cidade, senha);
                listaLocadoras.add(locadora);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }
}