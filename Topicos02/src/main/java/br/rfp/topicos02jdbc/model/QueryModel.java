package br.rfp.topicos02jdbc.model;

public class QueryModel {
    public QueryModel () {}

    public String queryInsert(PersonModel person) {
        return "INSERT INTO PESSOA SET NOME = '"+person.getName()+"', EMAIL = '"+person.getEmail()+"', CIDADE = '"+person.getCity()+"', " +
                " DT_ALTERACAO = CURDATE(), HR_ALTERACAO = CURTIME()";
    }

    public String queryUpdate(PersonModel person) {
        return "UPDATE PESSOA SET NOME = '"+person.getName()+"', EMAIL = '"+person.getEmail()+"', CIDADE = '"+person.getCity()+"', " +
                "DT_ALTERACAO = CURDATE(), HR_ALTERACAO = CURTIME() WHERE ID_PESSOA = "+person.getId();
    }

    public String querySelectAll() {
        return "SELECT NOME, EMAIL, CIDADE FROM PESSOA";
    }

    public String querySelect(int id) {
        return "SELECT NAME, EMAIL, CIDADE FROM PESSOA WHERE ID_PESSOA = "+id;
    }
}
