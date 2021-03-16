package br.cassiogamarra.view;

import br.cassiogamarra.controller.ControllerArquivo;
import br.cassiogamarra.controller.ControllerConexao;
import br.cassiogamarra.controller.ControllerRegistro;

import javax.swing.*;

public class MainView {

    static ControllerArquivo controllerArquivo = new ControllerArquivo();
    public static void main( String[] args ){
        ControllerConexao controllerConexao = new ControllerConexao();

        if(controllerConexao.connect()) {
            controllerArquivo.getDataFromFile();
        } else if(!controllerConexao.connect()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
}
