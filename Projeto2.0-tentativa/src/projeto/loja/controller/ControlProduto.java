package projeto.loja.controller;

import java.util.List;
import java.util.Scanner;

import projeto.loja.modulos.Headset;
import projeto.loja.modulos.Mouse;
import projeto.loja.modulos.ListaProduto;
import projeto.loja.modulos.Teclado;
import projeto.loja.tela.TelaDePedidos;
import projeto.loja.tela.TelaDeProdutos;
import projeto.loja.util.Mensagem;

public class ControlProduto {
	static ListaProduto estoque = new ListaProduto();
	static int i;
	
	public static void cadastrar() {
		Scanner leitor = new Scanner (System.in);
		int opcao;
		String nome_produto;
		double valor;
		
		System.out.println(Mensagem.CADASTRO_PRODUTO);
		System.out.println(Mensagem.MSG_ESCOLHA_PRODUTO);
		System.out.println(Mensagem.MSG_TECLADO);
		System.out.println(Mensagem.MSG_HEADSET);
		System.out.println(Mensagem.MSG_MOUSE);
		opcao = leitor.nextInt();
		leitor.nextLine();
		
		switch(opcao) {
		case 1:
		
		System.out.println(Mensagem.ADD_TECLADO);
			
		System.out.println(Mensagem.NOME_PRODUTO);
		nome_produto = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		valor = leitor.nextDouble();
		
		
		
		Teclado teclado = new Teclado();
		
		teclado.setNome(nome_produto);
		teclado.setValor(valor);
		
		estoque.adicionar(teclado);
		
		System.out.println(Mensagem.PRODUTO_ADD);
		
		break;
		case 2:
			
			System.out.println(Mensagem.ADD_HEADSET);
			
			System.out.println(Mensagem.NOME_PRODUTO);
			nome_produto = leitor.nextLine();
			
			System.out.println(Mensagem.VALOR_PRODUTO);
			valor = leitor.nextDouble();
			
			Headset headset = new Headset();
		
			headset.setNome(nome_produto);
			headset.setValor(valor);
			
			estoque.adicionar(headset);
			
			System.out.println(Mensagem.PRODUTO_ADD);
			
		break;
		case 3:
			
			System.out.println(Mensagem.ADD_MOUSE);
			
			System.out.println(Mensagem.NOME_PRODUTO);
			nome_produto = leitor.nextLine();
			
			System.out.println(Mensagem.VALOR_PRODUTO);
			valor = leitor.nextDouble();
			
			
			Mouse mouse = new Mouse();
			
			mouse.setNome(nome_produto);
			mouse.setValor(valor);
			
			estoque.adicionar(mouse);
			
			System.out.println(Mensagem.PRODUTO_ADD);
			
			
			break;
		
		}
		
		TelaDeProdutos.mostrar();
		leitor.close();
	}
	
	public static void listar() {
		
		if(estoque.getTeclados().size() == 0 && estoque.getHeadsets().size() == 0 && estoque.getMouse().size()==0) {
			
			System.out.println(Mensagem.ADD_PRODUTO);
			
		}else{
		if(estoque.getTeclados().size() == 0) {
			System.out.println();
		}else {	
		System.out.println(Mensagem.TELA_LISTA_PRODUTOS);
		System.out.println(Mensagem.LISTA_TECLADOS);
		for(Teclado teclado : estoque.getTeclados()) {
			System.out.println(Mensagem.MSG_MARCA+teclado.getNome()+
							   Mensagem.MSG_VALOR+ teclado.getValor()+"\n");
			
			System.out.flush();
		}
}
		if(estoque.getHeadsets().size() == 0) {
		System.out.println();	
		}else {
			
			System.out.println(Mensagem.LISTA_HEADSETS);
			for(Headset headset : estoque.getHeadsets()) {
				System.out.println(Mensagem.MSG_MARCA+headset.getNome()+
								   Mensagem.MSG_VALOR+ headset.getValor()+"\n");
				
				System.out.flush();
			
			}
		}
	if(estoque.getMouse().size() == 0) {
			System.out.println();
	}
	else {
			System.out.println(Mensagem.LISTA_MOUSES);
			for(Mouse mouse : estoque.getMouse()) {
				System.out.println(Mensagem.MSG_MARCA+mouse.getNome()+
								   Mensagem.MSG_VALOR+ mouse.getValor()+"\n");
				
				System.out.flush();
		}
	}	
}
	TelaDeProdutos.mostrar();
}
	
	public static void excluir() {
		
		  Scanner leitor = new Scanner(System.in);
		  
		  System.out.println(Mensagem.MSG_ESCOLHA);
		  System.out.println(Mensagem.MSG_TECLADO+
				  	   "\n"+ Mensagem.MSG_HEADSET+ 
				  	   "\n"+ Mensagem.MSG_MOUSE);
		  int escolha = leitor.nextInt();  
		  leitor.nextLine();  
		  
		  switch (escolha) {
		  
		  case 1:
		   if(estoque.getTeclados().size()==0) {
			   System.out.println(Mensagem.ADD_PRODUTO);
			   TelaDeProdutos.mostrar();
		   }else {
 
		    for (Teclado teclado : estoque.getTeclados()) {
		        i++;
		        
		        System.out.println("\nID: ["+i+"]\n"+Mensagem.MSG_MARCA + teclado.getNome() +
		                                       Mensagem.MSG_VALOR + teclado.getValor()+"\n");
		      
		    }
		    
		    System.out.println(Mensagem.EXCLUIR_CLIENTE);

		    i = leitor.nextInt();
		    if (i > 0 && i <= estoque.getTeclados().size()) {
		        estoque.getTeclados().remove(i - 1);
		        System.out.println("\n"+Mensagem.REGISTRO_REMOVIDO+"\n");
		    } else {
		        System.out.println(Mensagem.OPCAO_INVALIDA);
		    }
		    i=0;
		    ControlProduto.listar();
		    leitor.close();
		}
		   break;
		  case 2:
			   if(estoque.getHeadsets().size()==0) {
				   System.out.println(Mensagem.ADD_PRODUTO);
				   TelaDeProdutos.mostrar();
			   }else {
	 
			    for (Headset headset : estoque.getHeadsets()) {
			        i++;
			        System.out.println("\nID: ["+i+"]\n"+Mensagem.MSG_MARCA + headset.getNome() +
			                                       Mensagem.MSG_VALOR + headset.getValor()+"\n");
			    }

			    System.out.println(Mensagem.EXCLUIR_CLIENTE);

			    i = leitor.nextInt();
			    if (i > 0 && i <= estoque.getHeadsets().size()) {
			        estoque.getHeadsets().remove(i - 1);
			        System.out.println(Mensagem.REGISTRO_REMOVIDO);
			    } else {
			        System.out.println(Mensagem.OPCAO_INVALIDA);
			    }
			    ControlProduto.listar();
			    leitor.close();
			}
			   break;
		  case 3:
			   if(estoque.getMouse().size()==0) {
				   System.out.println(Mensagem.ADD_PRODUTO);
				   TelaDeProdutos.mostrar();
			   }else {
	 
			    for (Mouse mouse : estoque.getMouse()) {
			        i++;
			       
			        System.out.println("\nID: ["+i+"]\n"+Mensagem.MSG_MARCA+ mouse.getNome() +
			                                        Mensagem.MSG_VALOR + mouse.getValor()+"\n");
			    }

			    System.out.println(Mensagem.EXCLUIR_CLIENTE);

			    i = leitor.nextInt();
			    if (i > 0 && i <= estoque.getMouse().size()) {
			        estoque.getMouse().remove(i - 1);
			        System.out.println(Mensagem.REGISTRO_REMOVIDO);
			    } else {
			        System.out.println(Mensagem.OPCAO_INVALIDA);
			    }
			    ControlProduto.listar();
			    leitor.close();
			}
			   break;
		  }
	}
	
	public static void atualizar() {
		
		Scanner leitor = new Scanner(System.in);
		  
		  System.out.println(Mensagem.MSG_ESCOLHA);
		  System.out.println(Mensagem.MSG_TECLADO+
				  	   "\n"+ Mensagem.MSG_HEADSET+ 
				  	   "\n"+ Mensagem.MSG_MOUSE);
		  int escolha = leitor.nextInt();  
		  leitor.nextLine();  
		  
		  switch (escolha) {
		  case 1:
			  for (int i = 0; i < estoque.getTeclados().size(); i++) {
			        Teclado teclado = estoque.getTeclados().get(i);
			        System.out.println((i + 1) + ". Nome: " + teclado.getNome() + " Valor: " + teclado.getValor()+"\n");
			    }
			    
			    System.out.println(Mensagem.ATUALIZAR_CLIENTE);
			    int opcao = leitor.nextInt();
			    leitor.nextLine();
			    
			    if (opcao < 1 || opcao > estoque.getTeclados().size()) {
			        System.out.println(Mensagem.OPCAO_INVALIDA);

			    }
			    else {
			  
			    Teclado teclado = estoque.getTeclados().get(opcao - 1);
			    
				System.out.println(Mensagem.NOME_PRODUTO);
				String nome_produto = leitor.nextLine();
				
				System.out.println(Mensagem.VALOR_PRODUTO);
				double valor = leitor.nextDouble();
				
			
				
				teclado.setNome(nome_produto);
				teclado.setValor(valor);
			
			
			    
			    System.out.println(Mensagem.MSG_ATUALIZAR);
			    
			    TelaDeProdutos.mostrar();
			    leitor.close();
			
			  
			    }
			  
			  break;
			  
		  case 2:
			  for (int i = 0; i < estoque.getHeadsets().size(); i++) {
			        Headset headset = estoque.getHeadsets().get(i);
			        System.out.println((i + 1) + ". Nome: " + headset.getNome() + 
			        		" Valor: "+ headset.getValor()+"\n");
			    }
			    
			    System.out.println(Mensagem.ATUALIZAR_CLIENTE);
			    opcao = leitor.nextInt();
			    leitor.nextLine();
			    
			    if (opcao < 1 || opcao > estoque.getHeadsets().size()) {
			        System.out.println(Mensagem.OPCAO_INVALIDA);

			    }
			    else {
			  
			    Headset headset = estoque.getHeadsets().get(opcao - 1);
			    
				System.out.println(Mensagem.NOME_PRODUTO);
				String nome_produto = leitor.nextLine();
				
				System.out.println(Mensagem.VALOR_PRODUTO);
				double valor = leitor.nextDouble();
				
			
				
				headset.setNome(nome_produto);
				headset.setValor(valor);
			
			
			    
			    System.out.println(Mensagem.MSG_ATUALIZAR);
			    
			    TelaDeProdutos.mostrar();
			    leitor.close();
			
			  
			    }
			  
			  break;
		  case 3:
			  
			  for (int i = 0; i < estoque.getMouse().size(); i++) {
			        Mouse mouse = estoque.getMouse().get(i);
			        System.out.println((i + 1) + ". Nome: " + mouse.getNome() + 
			        		" Valor: " + mouse.getValor()+"\n");
			    }
			    
			    System.out.println(Mensagem.ATUALIZAR_CLIENTE);
			    opcao = leitor.nextInt();
			    leitor.nextLine();
			    
			    if (opcao < 1 || opcao > estoque.getMouse().size()) {
			        System.out.println(Mensagem.OPCAO_INVALIDA);

			    }
			    else {
			  
			    Mouse mouse = estoque.getMouse().get(opcao - 1);
			    
				System.out.println(Mensagem.NOME_PRODUTO);
				String nome_produto = leitor.nextLine();
				
				System.out.println(Mensagem.VALOR_PRODUTO);
				double valor = leitor.nextDouble();
				
			
				
				mouse.setNome(nome_produto);
				mouse.setValor(valor);
			
			
			    
			    System.out.println(Mensagem.MSG_ATUALIZAR);
			    
			    TelaDeProdutos.mostrar();
			    leitor.close();
			
			  
			    }
			  
			  break;
			  
			  
		  }
		  
	}
	

	public static List<Teclado> getTecladoLista(){
		 return estoque.getTeclados();
	}
	
	public static List<Mouse> getMouseLista(){
		return estoque.getMouse();
		
	}
	
	public static List<Headset> getHeadsetLista(){
		return estoque.getHeadsets();
	}
}