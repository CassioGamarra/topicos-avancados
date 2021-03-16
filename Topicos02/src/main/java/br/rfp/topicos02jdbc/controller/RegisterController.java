package br.rfp.topicos02jdbc.controller;

import br.rfp.topicos02jdbc.model.PersonModel;
import br.rfp.topicos02jdbc.model.QueryModel;
import br.rfp.topicos02jdbc.model.RegisterModel;

import javax.management.Query;
import java.util.ArrayList;

public class RegisterController {
    public RegisterController () {}

    RegisterModel register = new RegisterModel();
    QueryModel queryModel = new QueryModel();

    public boolean registerPerson(String name, String email, String city) {
        PersonModel p = new PersonModel();
        p.setName(name);
        p.setEmail(email);
        p.setCity(city);

        return register.sqlExecute(queryModel.queryInsert(p));
    }

    public boolean updatePerson(int id, String name, String email, String city) {
        PersonModel p = new PersonModel();
        p.setId(id);
        p.setName(name);
        p.setEmail(email);
        p.setCity(city);

        return register.sqlExecute(queryModel.queryUpdate(p));
    }

    public String getPerson(int id) {
        return String.valueOf(register.sqlSelect(queryModel.querySelect(id)));
    }

    public String getPersons() {
        return String.valueOf(register.sqlSelect(queryModel.querySelectAll()));
    }
}
