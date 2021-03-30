package br.cassiogamarra.view;

import br.cassiogamarra.controller.ControllerArquivo;

import javax.swing.*;

public class ViewMain {

    static ControllerArquivo controllerArquivo = new ControllerArquivo();
    public static void main( String[] args ){
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo!");
        if(nomeArquivo.equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "ERRO!", JOptionPane.WARNING_MESSAGE);
        } else {
            nomeArquivo.replaceAll(".csv","");
            controllerArquivo.getDataFromFile(nomeArquivo+".csv");
        }
    }
}
