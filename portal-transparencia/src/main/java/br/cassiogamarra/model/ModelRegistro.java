package br.cassiogamarra.model;

import br.cassiogamarra.connection.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelRegistro {
    public ConnectionFactory conn = ConnectionFactory.getInstance();
    public Statement stmt;
    public ResultSet rs;

    // Para inserções, alterações e exclusões
    public boolean sqlExecute(String query) {
        try {
            stmt = conn.connectDatabase().createStatement();
            stmt.executeUpdate(query);
            conn.connectDatabase().close();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println(query);
        }
        return false;
    }

    // Para consultas
    public ResultSet sqlSelect(String query) {
        try {
            stmt = conn.connectDatabase().createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }
}
