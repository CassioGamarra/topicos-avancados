package br.rfp;

import java.util.List;


public class PessoaGUI {

	public static void main(String[] args) {
	
		Pessoa pessoa = new Pessoa();
		PessoaCRUD pessoaCRUD = new PessoaCRUD();
		pessoaCRUD.setup();

		// INSERT
        pessoa.setNome("Cássio");
        pessoa.setEmail("cassio@gmail.com");
        pessoa.setCidade("Santa Maria");
        pessoaCRUD.create(pessoa);

		/*
        // SELECT
		pessoa = pessoaCRUD.read(3);
		System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Email: " + pessoa.getEmail());
        System.out.println("Cidade: " + pessoa.getCidade());
        */
        
		/*
        // UPDATE
        pessoa.setId(2);
        pessoa.setNome("Pedro");
        pessoa.setEmail("pedro@yahoo.com");
        pessoa.setCidade("Itaara");
        pessoaCRUD.update(pessoa);
        */
        /*
        // DELETE
        pessoaCRUD.delete(1);
		*/
        
		
		// LIST ALL
		List<Pessoa> pessoas = pessoaCRUD.listAll();
		for (Pessoa p : pessoas) {
			System.out.println("ID: " + p.getId());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Email: " + p.getEmail());
			System.out.println("Cidade: " + p.getCidade()); 
			System.out.println("======================================");
		}
		
		
		// SELECT COM WHERE
		pessoa = pessoaCRUD.queryWhere(3);
		System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Email: " + pessoa.getEmail());
        System.out.println("Cidade: " + pessoa.getCidade());
           
           
	}      

}