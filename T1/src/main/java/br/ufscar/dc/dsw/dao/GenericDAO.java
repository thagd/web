package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAO<T> {

	public GenericDAO() {
        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {

    	String url = "jdbc:mysql://localhost:3306/Bicicletas?useTimezone=true&serverTimezone=UTC";
    	return DriverManager.getConnection(url, "sabs", "cotonete");
    }
}