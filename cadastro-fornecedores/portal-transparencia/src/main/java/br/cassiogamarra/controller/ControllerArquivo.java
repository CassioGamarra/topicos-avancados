package br.cassiogamarra.controller;

import br.cassiogamarra.model.ModelPessoa;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerArquivo {
    public ControllerArquivo(){}
    //Verifica no arquivo de conexão se existem os dados
    public void getDataFromFile() {
        ControllerRegistro registro = new ControllerRegistro();
        String nomeArquivo = "202103_PEP.csv";
        BufferedReader br = null;
        SimpleDateFormat fromModel = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            ModelPessoa p = new ModelPessoa();
            AtomicBoolean sucesso = new AtomicBoolean(false);
            br.lines()
                    .skip(1)
                    .map(linhas -> linhas.split(";"))
                    .forEach(
                          (item) -> {
                              p.setCpf(item[0].replaceAll("\"", ""));
                              p.setNome(item[1].replaceAll("\"", ""));
                              p.setSigla(item[2].replaceAll("\"", ""));
                              p.setDescricaoFuncao(item[3].replaceAll("\"", ""));
                              p.setNivelFuncao(item[4].replaceAll("\"", ""));
                              p.setNomeOrgao(item[5].replaceAll("\"", ""));
                              try{
                                  p.setDtIniExercicio(!item[6].contains("Não") ? dateFormat.format(fromModel.parse(item[6].replaceAll("\"", ""))) : "");
                                  p.setDtFimExercicio(!item[7].contains("Não") ? dateFormat.format(fromModel.parse(item[7].replaceAll("\"", ""))) : "");
                                  p.setDtFimCarencia(!item[8].contains("Não") ? dateFormat.format(fromModel.parse(item[8].replaceAll("\"", ""))): "");
                              } catch(ParseException ex) {
                                  Logger.getLogger(ControllerArquivo.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              sucesso.set(registro.registrarPessoa(p));
                          }
            );
            if(sucesso.get()) {
                System.out.println("Arquivo carregado em banco com sucesso!");
            } else {
                System.out.println("Erro ao carregar o arquivo!");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ControllerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
