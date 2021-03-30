package br.cassiogamarra.controller;

import br.cassiogamarra.model.ModelPessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.NoResultException;

public class ControllerRegistro {
    protected SessionFactory sessionFactory;

    protected void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            System.out.println(ex);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void exit() {
        sessionFactory.close();
    }

    protected boolean create(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(object);

        session.getTransaction().commit();
        session.close();
        return true;
    }

    protected boolean readPessoa(String cpf) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            ModelPessoa pessoa = session.createQuery("FROM ModelPessoa WHERE CPF = '"+cpf+"'", ModelPessoa.class).getSingleResult();
            session.close();
            return pessoa.getId() > 0 ? true : false;
        } catch (NoResultException nre) {
            session.close();
            return false;
        }
    }
}
