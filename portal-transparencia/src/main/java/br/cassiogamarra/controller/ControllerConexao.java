package br.cassiogamarra.controller;

import br.cassiogamarra.connection.ConnectionFactory;

public class ControllerConexao {
    public ControllerConexao(){}

    ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

    public boolean connect() {
        connectionFactory.setAddress("localhost");
        connectionFactory.setPort("3306");
        connectionFactory.setDbname("dbportaltransparencia");
        connectionFactory.setUser("root");
        connectionFactory.setPassword("123123");
        connectionFactory.connectDatabase();
        return connectionFactory.getStatus();
    }
}
