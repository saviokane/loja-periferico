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
	private static DAO<Headset> headsetDao = new HeadsetDAO();
	private static DAO<Mouse> mouseDao = new MouseDAO();
   
	
	public static void cadastrar() {
	    Scanner leitor = new Scanner(System.in);
	    int id = 0;
	    
	
	    
	    List<Pessoa> pessoas = pessoaDao.listar();
	    List<Integer> idsP = pessoaDao.obterTodosIds();
	    
	    
	    
	    if (pessoas.isEmpty()) {
	        System.out.println("Ainda não há clientes cadastrados!\n");
	    } else {
	        System.out.println("\n===Lista de Clientes===");
	        for (int i = 0; i < pessoas.size(); i++) {
	            Pessoa pessoa = pessoas.get(i);
	            int clienteId = idsP.get(i);

	            System.out.println("Id: " + clienteId);
	            System.out.println("Nome: " + pessoa.getNome());
	            System.out.println("CPF: " + pessoa.getCpf());
	            System.out.println("Telefone: " + pessoa.getTelefone());
	            System.out.println("Email: " + pessoa.getEmail());
	            System.out.println("-----------------------------");
	        }

	       
	        System.out.println("Digite o ID do cliente que fez o pedido:");
	        id = leitor.nextInt();
	        
	        Pessoa clienteSelecionado = pessoaDao.buscarPorId(id);
		    System.out.println("Pessoa Selecionado: "+clienteSelecionado.getNome());
		    String nomeSelecionado = clienteSelecionado.getNome();
		    String cpfSelecionado = clienteSelecionado.getCpf();
		    String telefoneSelecionado = clienteSelecionado.getTelefone();
	        
	        leitor.nextLine();
	        System.out.println("Selecione o tipo de produto: ");
		    System.out.println("[1] - Teclado");
		    System.out.println("[2] - Mouse");
		    System.out.println("[3] - Headset");
		    int opcao = leitor.nextInt();
		    
	    
	    
	    switch(opcao) {
	    case 1:
	    	
	    	List<Teclado> teclados = tecladoDao.listar();
	    	 List<Integer> ids = tecladoDao.obterTodosIds();
	    	id = 0;
	    	int selecionado = 0;
	    	for (int i = 0 ; i < teclados.size(); i++) {
	    		Teclado teclado = teclados.get(i);
	    		int tecladoId = ids.get(i);
		    	
				System.out.println(Mensagem.SEPARADOR);
				System.out.println("ID: "+tecladoId);
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
	 	    
	    	Teclado tecladoSelecionado = tecladoDao.buscarPorId(selecionado);
	    	System.out.println("Teclado Selecionado: "+ tecladoSelecionado.getNome());
	    	String produtoSelecionado = tecladoSelecionado.getNome();
	    	String valorSelecionado = tecladoSelecionado.getValor();
	    	


	        
		    	Pedido pedido = new Pedido(produtoSelecionado,valorSelecionado,nomeSelecionado,cpfSelecionado,telefoneSelecionado);
		    	pedidoDao.salvar(pedido);
		    	
	            System.out.println("\n====Pedido cadastrado com sucesso===\n");
	       

	    	
	    	TelaDePedidos.mostrar();
	    	
	    	
	    	break;
	    	
	    case 2:
	    	
	    	List<Mouse> mouses = mouseDao.listar();
	    	 List<Integer> idsmouse = mouseDao.obterTodosIds();

	    	id = 0;
	    	selecionado = 0;
	    	for (int i = 0 ; i < mouses.size(); i++) {
	    		Mouse mouse = mouses.get(i);
	    		int mouseid = idsmouse.get(i);
		    	
				System.out.println(Mensagem.SEPARADOR);
				System.out.println("ID: "+mouseid);
				System.out.println("Marca: " + mouse.getMarca());
				System.out.println("Nome: " + mouse.getNome());
				System.out.println("Valor: " + mouse.getValor());
				System.out.println("DPI: " + mouse.getDpi());
				System.out.println("Peso: " + mouse.getPeso());
				System.out.println("Tempo Resposta: " + mouse.getTempoResposta());				
			}
	    	 
	    	System.out.println();
	    	System.out.println("Digite o ID: ");
	 	    selecionado = leitor.nextInt();
	 	    System.out.println();
	 	    
	    	Mouse mouseSelecionado = mouseDao.buscarPorId(selecionado);
	    	System.out.println("Teclado Selecionado: "+ mouseSelecionado.getNome());
	    	String mousesetnome = mouseSelecionado.getNome();
	    	String mouvalorSelecionado = mouseSelecionado.getValor();
	    	
	    	Pedido pedido_2 = new Pedido(mousesetnome,mouvalorSelecionado,nomeSelecionado,cpfSelecionado,telefoneSelecionado);
	    	pedidoDao.salvar(pedido_2);
	    	
	    	TelaDePedidos.mostrar();
	    	
	    	
	    	break;
	    	
	    	case 3:

		    	List<Headset> headsets = headsetDao.listar();
		    	 List<Integer> idshed = headsetDao.obterTodosIds();

		    	id = 0;
		    	selecionado = 0;
		    	for (int i = 0 ; i < headsets.size(); i++) {
		    		Headset headset = headsets.get(i);
		    		int heasetId = idshed.get(i);
			    	
					System.out.println(Mensagem.SEPARADOR);
					System.out.println("ID: "+heasetId);
					System.out.println("Marca: " + headset.getMarca());
					System.out.println("Nome: " + headset.getNome());
					System.out.println("Valor: " + headset.getValor());
					System.out.println("SwitchType: " + headset.getConectores());
					System.out.println("modelo: " + headset.getModelo());
					System.out.println("Layout: " + headset.getDrivers());				
				}
		    	 
		    	System.out.println();
		    	System.out.println("Digite o ID: ");
		 	    selecionado = leitor.nextInt();
		 	    System.out.println();
		 	    
		    	Headset headsetSelecionado = headsetDao.buscarPorId(selecionado);
		    	System.out.println("Teclado Selecionado: "+ headsetSelecionado.getNome());
		    	String headsetnome = headsetSelecionado.getNome();
		    	String hedvalorSelecionado = headsetSelecionado.getValor();
		    	
		    	Pedido pedido_3 = new Pedido(headsetnome,hedvalorSelecionado,nomeSelecionado,cpfSelecionado,telefoneSelecionado);
		    	pedidoDao.salvar(pedido_3);
		    	
		    	TelaDePedidos.mostrar();
		    	
		    	
		    	break;
		    	
	    	
	  
	    }}
	}
	
	public static void listar() {
		List<Pedido> pedidos = pedidoDao.listar();
		if(pedidos.size() == 0) {
			System.out.println("\n===Não há pedidos realizados");
		}else {
			System.out.println("\n===Pedidos===");
	for(Pedido pedido : pedidos) {
		
		System.out.println(Mensagem.SEPARADOR);
		System.out.println("Produto: "+pedido.getProduto());
		System.out.println("Valor R$"+pedido.getValor());
		System.out.println("Cliente: "+pedido.getNome());
		System.out.println("CPF: "+pedido.getCpf());
		System.out.println("Telefone: "+pedido.getTelefone());
			}
		}
		TelaDePedidos.mostrar();
}
	
	public static void atualizar() {

		Scanner leitor = new Scanner(System.in);

		
		List<Pedido> pedidos = pedidoDao.listar();
		List<Integer> idsPe = pedidoDao.obterTodosIds(); 
		
		System.out.println("\n==Atualizar Pedido==\n");
		    	 
		for(int i = 0; i < pedidos.size(); i++) {
			Pedido  pedido = pedidos.get(i);
    		int pedidoId = idsPe.get(i);
			
			System.out.println("Id: " + pedidoId );
			System.out.println("Cliente: " + pedido.getNome()+
				"\nProduto "+ pedido.getProduto()+
					"\nValor: "+ pedido.getValor());
			 System.out.println("-----------------------------");
			
		}
		
		
		System.out.println("\nInforme o id a ser modificado: ");
		Integer id = leitor.nextInt();
		leitor.nextLine();
		
			Pedido pedidoAtualizado = pedidoDao.buscarPorId(id);
			List<Pessoa> pessoas = pessoaDao.listar();
		    List<Integer> idsP = pessoaDao.obterTodosIds();
		    
		    
		    
		    if (pessoas.isEmpty()) {
		        System.out.println("Ainda não há clientes cadastrados!\n");
		    } else {
		        System.out.println("\n===Lista de Clientes===");
		        for (int i = 0; i < pessoas.size(); i++) {
		            Pessoa pessoa = pessoas.get(i);
		            int clienteId = idsP.get(i);

		            System.out.println("Id: " + clienteId);
		            System.out.println("Nome: " + pessoa.getNome());
		            System.out.println("CPF: " + pessoa.getCpf());
		            System.out.println("Telefone: " + pessoa.getTelefone());
		            System.out.println("Email: " + pessoa.getEmail());
		            System.out.println("-----------------------------");
		        }

		    }
		        System.out.println("\nDigite o ID do cliente que fez o pedido:");
		        id = leitor.nextInt();
		        Pessoa pessoaAtualizada = pessoaDao.buscarPorId(id);
				
		        String nomeAtualizado = pessoaAtualizada.getNome();
				String cpfAtualizado = pessoaAtualizada.getCpf();
				String telefoneAtualizado = pessoaAtualizada.getTelefone();
		        
		        
		        System.out.println("Selecione o tipo de produto: ");
			    System.out.println("[1] - Teclado");
			    System.out.println("[2] - Mouse");
			    System.out.println("[3] - Headset");
			    int opcao = leitor.nextInt();
			    
		    
		    
		    switch(opcao) {
		    case 1:
		    	
		    	List<Teclado> teclados = tecladoDao.listar();
		    	 List<Integer> ids = tecladoDao.obterTodosIds();
		    	id = 0;
		    	int selecionado = 0;
		    	for (int i = 0 ; i < teclados.size(); i++) {
		    		Teclado teclado = teclados.get(i);
		    		int tecladoId = ids.get(i);
			    	
					System.out.println(Mensagem.SEPARADOR);
					System.out.println("ID: "+tecladoId);
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
		 	    
		    	Teclado tecladoSelecionado = tecladoDao.buscarPorId(selecionado);
		    	
		    	

		    	String produtoAtualizado = tecladoSelecionado.getNome();
				String valorAtualizado = tecladoSelecionado.getValor();
								
				
				pedidoAtualizado.setProduto(produtoAtualizado);
				pedidoAtualizado.setNome(nomeAtualizado);
				pedidoAtualizado.setValor(valorAtualizado);
				pedidoAtualizado.setCpf(cpfAtualizado);
				pedidoAtualizado.setTelefone(telefoneAtualizado);
				
				pedidoDao.atualizar(pedidoAtualizado);
				
				
				listar();
		  
		            System.out.println("\n====Pedido cadastrado com sucesso===\n");
		       

		    	
		    	TelaDePedidos.mostrar();
		    	
		    	
		    	break;
		    	
		    case 2:
		    	
		    	List<Mouse> mouses = mouseDao.listar();
		    	 List<Integer> idsmouse = mouseDao.obterTodosIds();

		    	id = 0;
		    	selecionado = 0;
		    	for (int i = 0 ; i < mouses.size(); i++) {
		    		Mouse mouse = mouses.get(i);
		    		int mouseid = idsmouse.get(i);
			    	
					System.out.println(Mensagem.SEPARADOR);
					System.out.println("ID: "+mouseid);
					System.out.println("Marca: " + mouse.getMarca());
					System.out.println("Nome: " + mouse.getNome());
					System.out.println("Valor: " + mouse.getValor());
					System.out.println("DPI: " + mouse.getDpi());
					System.out.println("Peso: " + mouse.getPeso());
					System.out.println("Tempo Resposta: " + mouse.getTempoResposta());				
				}
		    	 
		    	System.out.println();
		    	System.out.println("Digite o ID: ");
		 	    selecionado = leitor.nextInt();
		 	    System.out.println();
		 	   Mouse MouseSelecionado = mouseDao.buscarPorId(selecionado);
		    	
		    	

		    	String produtoMouseAtualizado = MouseSelecionado.getNome();
				String valorMouseAtualizado = MouseSelecionado.getValor();
								
				
				pedidoAtualizado.setProduto(produtoMouseAtualizado );
				pedidoAtualizado.setNome(nomeAtualizado);
				pedidoAtualizado.setValor(valorMouseAtualizado);
				pedidoAtualizado.setCpf(cpfAtualizado);
				pedidoAtualizado.setTelefone(telefoneAtualizado);
				
				pedidoDao.atualizar(pedidoAtualizado);
	
		    	
		    	TelaDePedidos.mostrar();
		    	
		    	
		    	break;
		    	
		    	case 3:

			    	List<Headset> headsets = headsetDao.listar();
			    	 List<Integer> idshed = headsetDao.obterTodosIds();

			    	id = 0;
			    	selecionado = 0;
			    	for (int i = 0 ; i < headsets.size(); i++) {
			    		Headset headset = headsets.get(i);
			    		int heasetId = idshed.get(i);
				    	
						System.out.println(Mensagem.SEPARADOR);
						System.out.println("ID: "+heasetId);
						System.out.println("Marca: " + headset.getMarca());
						System.out.println("Nome: " + headset.getNome());
						System.out.println("Valor: " + headset.getValor());
						System.out.println("SwitchType: " + headset.getConectores());
						System.out.println("modelo: " + headset.getModelo());
						System.out.println("Layout: " + headset.getDrivers());				
					}
			    	 
			    	System.out.println();
			    	System.out.println("Digite o ID: ");
			 	    selecionado = leitor.nextInt();
			 	    System.out.println();
			 	    
			    	Headset headsetSelecionado = headsetDao.buscarPorId(selecionado);
			    	
			    	String produtoHeadAtualizado = headsetSelecionado.getNome();
					String valorHeadAtualizado = headsetSelecionado.getValor();
									
					
					pedidoAtualizado.setProduto(produtoHeadAtualizado);
					pedidoAtualizado.setNome(nomeAtualizado);
					pedidoAtualizado.setValor(valorHeadAtualizado);
					pedidoAtualizado.setCpf(cpfAtualizado);
					pedidoAtualizado.setTelefone(telefoneAtualizado);
					
			    	
			    	TelaDePedidos.mostrar();
			    	
			    	
			    	break;
			    	
		    }
		// Atualização do pedido
	
		

	}
	
	public static void excluir() {
		List<Pedido> pedidos = pedidoDao.listar();
		List<Integer> idsPe = pedidoDao.obterTodosIds(); 
		    	 
		for(int i = 0; i < pedidos.size(); i++) {
			Pedido  pedido = pedidos.get(i);
    		int pedidoId = idsPe.get(i);
			
			System.out.println("Id: " + pedidoId );
			System.out.println("Cliente: " + pedido.getNome()+
				"\nProduto "+ pedido.getProduto()+
					"\nValor: "+ pedido.getValor());
			 System.out.println("-----------------------------");
			
		}
		
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Informe o id a ser excluido: ");
		int id = leitor.nextInt();
		
		pedidoDao.excluir(id);
		
		TelaDePedidos.mostrar();
	}
	
}
