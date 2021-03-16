package br.rfp.topicos02jdbc.connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private String url;
    private String address;
    private String port;
    private String dbname;
    private String user;
    private String password;

    //Implementar um status da conexão
    private boolean status;

    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        if(instance == null){
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection connectDatabase() {
        url = "jdbc:mysql://"+getAddress()+":"+getPort()+"/"+getDbname()+"?useTimezone=true&serverTimezone=UTC";
        user = getUser();
        password = getPassword();
        return connect();
    }

    private Connection connect() {
        Connection connect = null;
        try{
            connect = DriverManager.getConnection(url, user, password);
            setStatus(true);
            return connect;
        }
        catch(SQLException e){
            setStatus(false);
        }
        return null;
    }

    //Getter e Setter
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
