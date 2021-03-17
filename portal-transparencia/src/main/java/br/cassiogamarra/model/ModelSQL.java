package br.cassiogamarra.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ModelSQL {
    public ModelSQL() {}

    public String queryInsert(ModelPessoa p) {
        String sql = "INSERT INTO PESSOA (CPF, NOME_PEP, SIGLA_FUNCAO, DESCR_FUNCAO, NOME_ORGAO, DT_INICIO_EXERCICIO, DT_FIM_EXERCICIO, DT_FIM_CARENCIA)" +
                "VALUES ('"+p.getCpf()+"','"+p.getNome()+"','"+p.getSigla()+"','"+p.getDescricaoFuncao()+"','"+p.getNomeOrgao()+"'";

        sql += p.getDtIniExercicio().length() > 0 ? ",'"+p.getDtIniExercicio()+"'" : ", NULL";
        sql += p.getDtFimExercicio().length() > 0 ? ",'"+p.getDtFimExercicio()+"'" : ", NULL";
        sql += p.getDtFimCarencia().length() > 0 ?  ",'"+p.getDtFimCarencia()+"'" : ", NULL";
        sql += ")";
        System.out.println(sql);
        return sql;
    }

    public String querySearch(String cpf) {
        return "SELECT ID_PESSOA FROM PESSOA WHERE CPF = '"+cpf+"'";
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
