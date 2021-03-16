package br.cassiogamarra.controller;

import br.cassiogamarra.model.ModelPessoa;
import br.cassiogamarra.model.ModelSQL;
import br.cassiogamarra.model.ModelRegistro;

public class ControllerRegistro {
    public ControllerRegistro() {}

    ModelRegistro register = new ModelRegistro();
    ModelSQL queryModel = new ModelSQL();

    public boolean registrarPessoa(ModelPessoa p) {
        return register.sqlExecute(queryModel.queryInsert(p));
    }

    public boolean updatePerson(int id, String name, String email, String city) {
        ModelPessoa p = new ModelPessoa();
        p.setId(id);
        return register.sqlExecute(queryModel.queryUpdate(p));
    }

    public String getPerson(int id) {
        return String.valueOf(register.sqlSelect(queryModel.querySelect(id)));
    }

    public String getPersons() {
        return String.valueOf(register.sqlSelect(queryModel.querySelectAll()));
    }
}
