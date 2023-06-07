package principal.controller;
import java.util.List;
import java.util.Scanner;
import principal.daos.*;

import principal.model.*;
import principal.tela.TelaDePedidos;
import principal.tela.TelaPrincipal;
import projeto.loja.util.Mensagem;
public class PedidoController {

	private static DAO<Pedido> pedidoDao = new PedidoDAO();
	private static DAO<Pessoa> pessoaDao = new PessoaDAO();
	private static DAO<Teclado> tecladoDao = new TecladoDAO();
	
	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);
		List<Pessoa> pessoas = pessoaDao.listar();
		
		int selecionado;
		int id = 0;
		int opcao = 0;
		System.out.println("Selecione o ID do Cliente: ");
	    for (Pessoa pessoa : pessoas) {
	    	
	    	id++;
	    	System.out.println("ID: "+id);
	        System.out.println("Nome: " + pessoa.getNome());
	        System.out.println("CPF: " + pessoa.getCpf());
	        System.out.println("Telefone: " + pessoa.getTelefone());
	        System.out.println("Email: " + pessoa.getEmail());
	        System.out.println("-----------------------------");
	    }
	    
	    System.out.println("Digite o ID: ");
	    selecionado = leitor.nextInt();
	    
	    
	    Pessoa clienteSelecionado = pessoas.get(selecionado -1);
	    System.out.println("Pessoa Selecionado: "+clienteSelecionado.getNome());
	    String nomeSelecionado = pessoas.get(selecionado -1).getNome();
	    String cpfSelecionado = pessoas.get(selecionado -1).getCpf();
	    String telefoneSelecionado = pessoas.get(selecionado -1).getTelefone();
	    System.out.println();
	    System.out.println("Selecione o tipo de produto: ");
	    System.out.println("[1] - Teclado");
	    System.out.println("[2] - Mouse");
	    System.out.println("[3] - Headset");
	    opcao = leitor.nextInt();
	    
	    switch(opcao) {
	    case 1:
	    	
	    	List<Teclado> teclados = tecladoDao.listar();
	    	id = 0;
	    	selecionado = 0;
	    	for (Teclado teclado : teclados) {
	    		id++;
		    	
				System.out.println(Mensagem.SEPARADOR);
				System.out.println("ID: "+id);
				System.out.println("Marca: " + teclado.getMarca());
				System.out.println("Nome: " + teclado.getNome());
				System.out.println("Valor: " + teclado.getValor());
				System.out.println("SwitchType: " + teclado.getSwitchType());
				System.out.println("modelo: " + teclado.getModelo());
				System.out.println("Layout: " + teclado.getLayout());				
			}
	    	 
	    	System.out.println();
	    	System.out.println("Digite o ID: ");
	 	    selecionado = leitor.nextInt();
	 	    System.out.println();
	    	Teclado tecladoSelecionado = teclados.get(selecionado -1);
	    	System.out.println("Teclado Selecionado: "+ tecladoSelecionado.getNome());
	    	
	    	String produtoSelecionado = tecladoSelecionado.getNome();
	    	String valorSelecionado = tecladoSelecionado.getValor();
	    	Pedido pedido = new Pedido(produtoSelecionado,valorSelecionado,nomeSelecionado,cpfSelecionado,telefoneSelecionado);
	    	pedidoDao.salvar(pedido);
	    	TelaDePedidos.mostrar();
	    	
	    	
	    	break;
	    	
	    	case 2:
	    		TelaPrincipal.mostrar();
	    	// aqui vai ser os outros produtos
	    	break;
	    }
	}
	
	public static void listar() {
		List<Pedido> pedidos = pedidoDao.listar();
	for(Pedido pedido : pedidos) {
		System.out.println(Mensagem.SEPARADOR);
		System.out.println("Produto: "+pedido.getProduto());
		System.out.println("Valor R$"+pedido.getValor());
		System.out.println("Cliente: "+pedido.getNome());
		System.out.println("CPF: "+pedido.getCpf());
		System.out.println("Telefone: "+pedido.getTelefone());
	}
	TelaDePedidos.mostrar();
	}
	
	public static void atualizar() {

		Scanner leitor = new Scanner(System.in);
		 
		System.out.println("Informe o id a ser modificado: ");
		Integer id = leitor.nextInt();
		leitor.nextLine();
		Pedido pedidoAtualizado = pedidoDao.buscarPorId(id);
		
		
		// Atualização do pedido
		System.out.println("Produto: ");
		String produtoAtualizado = leitor.nextLine();
		
		System.out.println("Valor: ");
		String valorAtualizado = leitor.nextLine();
		
		System.out.println("Cliente: ");
		String nomeAtualizado = leitor.nextLine();
		
		System.out.println("CPF:: ");
		String cpfAtualizado = leitor.nextLine();
		
		System.out.println("Telefone: ");
		String telefoneAtualizado = leitor.nextLine();
		
		pedidoAtualizado.setProduto(produtoAtualizado);
		pedidoAtualizado.setNome(nomeAtualizado);
		pedidoAtualizado.setValor(valorAtualizado);
		pedidoAtualizado.setCpf(cpfAtualizado);
		pedidoAtualizado.setTelefone(telefoneAtualizado);
		
		pedidoDao.atualizar(pedidoAtualizado);
		
		
		TelaPrincipal.mostrar();
		
		// PRECISO TERMINAR O CRUD COMPLETO DE TODOS OS HARDWARE COMO HEADSET E MOUSES E
		// E TAMBEM RETORNAR OS IDS RESPECTIVOS QUANDO PUXAR O A LISTA EM UM FOR, 
		//PQ NEM SEMPRE ESTÁ EM ORDEM NUMERICA EX: 1 2 3 4 
		
	}
	
	public static void excluir() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Informe o id a ser excluido: ");
		int id = leitor.nextInt();
		
		pedidoDao.excluir(id);
		
		TelaDePedidos.mostrar();
	}
	
}
