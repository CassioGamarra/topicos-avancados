package br.rfp.topicos02jdbc.controller;

import br.rfp.topicos02jdbc.connection.ConnectionFactory;

public class ConnectionController {
    public ConnectionController(){}

    ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

    public boolean connect() {
        connectionFactory.setAddress("localhost");
        connectionFactory.setPort("3306");
        connectionFactory.setDbname("DBTOPICOS");
        connectionFactory.setUser("root");
        connectionFactory.setPassword("123123");
        connectionFactory.connectDatabase();
        return connectionFactory.getStatus();
      }
}
