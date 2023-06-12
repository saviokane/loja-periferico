package principal.controller;

import java.util.List;
import java.util.Scanner;

import principal.daos.DAO;
import principal.daos.PessoaDAO;
import principal.model.Pessoa;
import projeto.loja.util.Mensagem;
import 	principal.tela.*;


public class ClienteController {

	private static  DAO<Pessoa> dao = new PessoaDAO();


	public static void listar() {
	  
	    List<Pessoa> pessoas = dao.listar();

	    if(dao.listar().size()== 0) {
	    	
	    	System.out.println("\nAinda não ha clientes cadastrados!\n");
	    	
	    }else {
	    	  System.out.println("\n=====Lista de Clientes=====\n");
	    for (Pessoa pessoa : pessoas) {
	        System.out.println("Nome: " + pessoa.getNome());
	        System.out.println("CPF: " + pessoa.getCpf());
	        System.out.println("Telefone: " + pessoa.getTelefone());
	        System.out.println("Email: " + pessoa.getEmail());
	        System.out.println("-----------------------------");
	    	}
	    
	   }
	    TelaDeClientes.mostrar();
	}
			
	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);

		System.out.println("\n===Cadastrar Cliente===\n");
	System.out.println(Mensagem.CADASTRA_NOME);
	String nome = leitor.nextLine();
	
	System.out.println(Mensagem.CADASTRA_CPF);
	String cpf = leitor.nextLine();
	
	System.out.println(Mensagem.CADASTRA_TELEFONE);
	String telefone = leitor.nextLine();
	
	System.out.println(Mensagem.CADASTRA_EMAIL);
	String email = leitor.nextLine();
	
	Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
	
	
	dao.salvar(pessoa);
	System.out.println("\n"+Mensagem.MSG_CLIENTE+nome+"\n");
	
	TelaDeClientes.mostrar();
	leitor.close();

	}	
	
	public static void atualizar() {
	    Scanner leitor = new Scanner(System.in);
	    int id = 0;
	    
		 List<Pessoa> pessoas = dao.listar();
		    List<Integer> ids = dao.obterTodosIds();
		    System.out.println("\n===Atualizar Cadastro===\n");

		    if (pessoas.isEmpty()) {
		        System.out.println("Ainda não há clientes cadastrados!\n");
		    } else {
		        
		    	System.out.println("Lista de Clientes\n");
		        
		        
		        for (int i = 0; i < pessoas.size(); i++) {
		            Pessoa pessoa = pessoas.get(i);
		            int clienteId = ids.get(i);

		            System.out.println("Id: " + clienteId);
		            System.out.println("Nome: " + pessoa.getNome());
		            System.out.println("CPF: " + pessoa.getCpf());
		            System.out.println("Telefone: " + pessoa.getTelefone());
		            System.out.println("Email: " + pessoa.getEmail());
		            System.out.println("-----------------------------");
		        }

		       
		        System.out.println("Digite o ID do cliente que deseja excluir:");
		        id = leitor.nextInt();
		        leitor.nextLine();
		     
		Pessoa pessoaAtualizada = dao.buscarPorId(id);
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_CPF);
		String cpf = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_TELEFONE);
		String telefone = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_EMAIL);
		String email = leitor.nextLine();
		
		pessoaAtualizada.setNome(nome); 
		pessoaAtualizada.setCpf(cpf);
		pessoaAtualizada.setEmail(email);
		pessoaAtualizada.setTelefone(telefone);
		
		
		dao.atualizar(pessoaAtualizada);
		
		System.out.println("===Cadastro Atualizado===");
		
		TelaDeClientes.mostrar();
	}
	}

	public static void excluir() {
	    Scanner leitor = new Scanner(System.in);
	    int id = 0;
	    
	
	    
	    List<Pessoa> pessoas = dao.listar();
	    List<Integer> ids = dao.obterTodosIds();
	    
	    
	    
	    if (pessoas.isEmpty()) {
	        System.out.println("Ainda não há clientes cadastrados!\n");
	    } else {
	        System.out.println("Lista de Clientes:");
	        for (int i = 0; i < pessoas.size(); i++) {
	            Pessoa pessoa = pessoas.get(i);
	            int clienteId = ids.get(i);

	            System.out.println("Id: " + clienteId);
	            System.out.println("Nome: " + pessoa.getNome());
	            System.out.println("CPF: " + pessoa.getCpf());
	            System.out.println("Telefone: " + pessoa.getTelefone());
	            System.out.println("Email: " + pessoa.getEmail());
	            System.out.println("-----------------------------");
	        }

	       
	        System.out.println("Digite o ID do cliente que deseja excluir:");
	        id = leitor.nextInt();
	        leitor.nextLine();

	        if (ids.contains(id)) {
	            dao.excluir(id);
	            System.out.println("\n====Cadastro excluído com sucesso!===\n");
	        } else {
	            System.out.println("ID inválido! Cliente não encontrado.");
	        }
	    }

	    TelaDeClientes.mostrar();
	}

	
}
