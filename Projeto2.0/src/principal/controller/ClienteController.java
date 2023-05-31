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
	    System.out.println("Segue a listinha, meu parça!");
	    List<Pessoa> pessoas = dao.listar();

	    for (Pessoa pessoa : pessoas) {
	        System.out.println("Nome: " + pessoa.getNome());
	        System.out.println("CPF: " + pessoa.getCpf());
	        System.out.println("Telefone: " + pessoa.getTelefone());
	        System.out.println("Email: " + pessoa.getEmail());
	        System.out.println("-----------------------------");
	    }
	    TelaDeClientes.mostrar();
	}

	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);

		
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
		System.out.println("me diga quem deseja atualizar?");
		int id = leitor.nextInt();
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
		
		TelaDeClientes.mostrar();
	}

	public static void excluir() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("me diga quem deseja atualizar?");
		int id = leitor.nextInt();
		leitor.nextLine();
			
		dao.excluir(id);
		
		TelaDeClientes.mostrar();
		
	}
	
}

