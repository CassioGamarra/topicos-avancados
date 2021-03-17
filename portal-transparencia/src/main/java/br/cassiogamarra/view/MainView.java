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
            String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo!");
            if(nomeArquivo.equals("")) {
                JOptionPane.showMessageDialog(null, "Nome inválido!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            } else {
                nomeArquivo.replaceAll(".csv","");
                controllerArquivo.getDataFromFile(nomeArquivo+".csv");
            }
        } else if(!controllerConexao.connect()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
}
