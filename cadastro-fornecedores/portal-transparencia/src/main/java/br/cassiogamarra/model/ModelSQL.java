package br.cassiogamarra.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ModelSQL {
    public ModelSQL() {}

    public String queryInsert(ModelPessoa p) {
        return "INSERT INTO PESSOA (CPF, NOME_PEP, SIGLA_FUNCAO, DESCR_FUNCAO, NOME_ORGAO, DT_INICIO_EXERCICIO, DT_FIM_EXERCICIO, DT_FIM_CARENCIA)" +
                "VALUES ('"+p.getCpf()+"','"+p.getNome()+"','"+p.getSigla()+"','"+p.getDescricaoFuncao()+"','"+p.getNomeOrgao()+"', '"+p.getDtIniExercicio()+"', '"+p.getDtFimExercicio()+"', '"+p.getDtFimCarencia()+"')";
    }

    public String queryUpdate(ModelPessoa person) {
        return "";
    }

    public String querySelectAll() {
        return "SELECT NOME, EMAIL, CIDADE FROM PESSOA";
    }

    public String querySelect(int id) {
        return "SELECT NAME, EMAIL, CIDADE FROM PESSOA WHERE ID_PESSOA = "+id;
    }
}
