package br.cassiogamarra.controller;

import br.cassiogamarra.model.ModelPessoa;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerArquivo {
    public ControllerArquivo(){}
    //Verifica no arquivo de conexão se existem os dados
    public void getDataFromFile(String nomeArquivo) {
        ControllerRegistro registro = new ControllerRegistro();
        registro.setup();
        BufferedReader br = null;
        SimpleDateFormat fromModel = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            ModelPessoa p = new ModelPessoa();
            AtomicBoolean sucesso = new AtomicBoolean(false);
            AtomicBoolean hasRegister = new AtomicBoolean(false);
            AtomicInteger counter = new AtomicInteger(0);
            String regex = "\"";
            br.lines()
                    .skip(1)
                    .map(linhas -> linhas.split(";"))
                    .forEach(
                            (item) -> {
                                p.setCpf(item[0].replaceAll(regex, ""));
                                p.setNome(item[1].replaceAll(regex, "").replace("'", "\\'"));
                                p.setSigla(item[2].replaceAll(regex, ""));
                                p.setDescricaoFuncao(item[3].replaceAll(regex, "").replace("'", "\\'"));
                                p.setNivelFuncao(item[4].replaceAll(regex, "").replace("'", "\\'"));
                                p.setNomeOrgao(item[5].replaceAll(regex, "").replace("'", "\\'"));
                                try{
                                    String dtIniExercicio, dtFimExercicio, dtFimCarencia = "";

                                    dtIniExercicio = (!item[6].contains("Não") ? dateFormat.format(fromModel.parse(item[6].replaceAll("\"", ""))) : "");
                                    dtFimExercicio = (!item[7].contains("Não") ? dateFormat.format(fromModel.parse(item[7].replaceAll("\"", ""))) : "");
                                    dtFimCarencia = (!item[8].contains("Não") ? dateFormat.format(fromModel.parse(item[8].replaceAll("\"", ""))) : "");

                                    p.setDtIniExercicio(dtIniExercicio.length() > 0 ? dtIniExercicio : null);
                                    p.setDtFimExercicio(dtFimExercicio.length() > 0 ? dtFimExercicio : null);
                                    p.setDtFimCarencia(dtFimCarencia.length() > 0 ? dtFimCarencia : null);
                                } catch(ParseException ex) {
                                    Logger.getLogger(ControllerArquivo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                hasRegister.set(registro.readPessoa(p.getCpf()));
                                if(!hasRegister.get()) {
                                    sucesso.set(registro.create(p));
                                    counter.getAndIncrement();
                                    System.out.println("Registro "+counter.get());
                                }
                            }
                    );
            if(sucesso.get()) {
                JOptionPane.showMessageDialog(null, "Arquivo carregado em banco com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar o arquivo ou os registros já existem!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo!", "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
