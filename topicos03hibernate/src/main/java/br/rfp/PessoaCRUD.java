//CONTROLLER

package br.rfp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class PessoaCRUD {
    protected SessionFactory sessionFactory;
 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	      //  .configure() // configures settings from hibernate.cfg.xml
    	      //  .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    		//sessionFactory = configuration.buildSessionFactory();
    	} catch (Exception ex) {
    	   StandardServiceRegistryBuilder.destroy(registry);
    		
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    }

    
    protected void create(Pessoa pessoa) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(pessoa);
        
        session.getTransaction().commit();
        session.close();
    }
    
 
    protected Pessoa read(int pessoaId) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Pessoa pessoa = session.get(Pessoa.class, pessoaId);
     
        session.close();
        return pessoa;
    }
 
    protected void update(Pessoa pessoa) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

    	session.update(pessoa);

    	session.getTransaction().commit();
    	session.close(); 	
    }
 
    protected void delete(int pessoaId) {
    	Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaId);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(pessoa);
     
        session.getTransaction().commit();
        session.close();
    }
    

    
    public List<Pessoa> listAll() {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();

        // leitura via Hibernate Query Language (HQL).
        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).getResultList();
        session.getTransaction().commit();

        return pessoas;
    }
    
    public Pessoa queryWhere(int id) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Pessoa pessoa = session.createQuery("from Pessoa where id="+id, Pessoa.class).getSingleResult();
        
        session.close();
        return pessoa;
    }


}