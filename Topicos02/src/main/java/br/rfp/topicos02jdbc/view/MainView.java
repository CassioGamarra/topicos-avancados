package br.rfp.topicos02jdbc.view;

import br.rfp.topicos02jdbc.controller.ConnectionController;
import br.rfp.topicos02jdbc.controller.RegisterController;

import javax.swing.*;

public class MainView {

    static RegisterController registerController = new RegisterController();
    public static void main( String[] args ){
        ConnectionController connectionController = new ConnectionController();

        if(connectionController.connect()) {
            int option;
            int id;
            String name, email, city;

            option = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir / 2 - Atualizar / 3 - Buscar por ID / 4 - Buscar todos"));

            if(option == 1) {
                name = JOptionPane.showInputDialog("Nome: ");
                email = JOptionPane.showInputDialog("Email: ");
                city = JOptionPane.showInputDialog("Cidade: ");
                if(registerController.registerPerson(name, email, city)) {
                    JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
                }
            } else if(option == 2) {
                id = Integer.parseInt(JOptionPane.showInputDialog("ID "));
                name = JOptionPane.showInputDialog("Nome: ");
                email = JOptionPane.showInputDialog("Email: ");
                city = JOptionPane.showInputDialog("Cidade: ");
                if(registerController.updatePerson(id, name, email, city)) {
                    JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
                }
            } else if(option == 3) {
                id = Integer.parseInt(JOptionPane.showInputDialog(("ID: ")));
                JOptionPane.showMessageDialog(null, registerController.getPerson(id));
            } else if(option == 4) {
                JOptionPane.showMessageDialog(null, registerController.getPersons());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada!");
            }
        } else if(!connectionController.connect()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
}
