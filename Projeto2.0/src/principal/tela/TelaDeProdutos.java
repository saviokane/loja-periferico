package principal.tela;

import java.util.Scanner;

import principal.controller.HeadsetController;
import principal.controller.MouseController;
import principal.controller.TecladoController;
import projeto.loja.util.Mensagem;

public class TelaDeProdutos {
	public static void mostrar() {
		
		Scanner leitor = new Scanner(System.in);
		int opcao;
	
		
		System.out.println(Mensagem.TELA_PRODUTOS);
		System.out.println();
		System.out.println("Selectione :");
		System.out.println(Mensagem.TELA_TECLADO);
		System.out.println(Mensagem.TELA_HEADSET);
		System.out.println(Mensagem.TELA_MOUSE);
		System.out.println("[4] "+Mensagem.MSG_VOLTAR);
		opcao = leitor.nextInt();
		
		switch(opcao) {
		case 1:
			opcao = 0;
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] "+Mensagem.MSG_LISTAR);
			System.out.println("[2] "+Mensagem.MSG_CADASTRAR);
			System.out.println("[3] "+Mensagem.MSG_EXCLUIR);
			System.out.println("[4] "+Mensagem.MSG_ALTERACAO);
			System.out.println("[5] "+Mensagem.MSG_VOLTAR);
			opcao = leitor.nextInt();

			
			switch(opcao) {
			case 1: 
				TecladoController.listar();
				break;
			case 2:
				TecladoController.cadastrar();
				break;
			case 3: 
				TecladoController.excluir();
				break;
			case 4:
				TecladoController.atualizar();
				break;
			case 5: 
				TelaPrincipal.mostrar();
				break;
		}
			break;
		case 2:
			opcao = 0;
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] "+Mensagem.MSG_LISTAR);
			System.out.println("[2] "+Mensagem.MSG_CADASTRAR);
			System.out.println("[3] "+Mensagem.MSG_EXCLUIR);
			System.out.println("[4] "+Mensagem.MSG_ALTERACAO);
			System.out.println("[5] "+Mensagem.MSG_VOLTAR);
			opcao = leitor.nextInt();

			
			switch(opcao) {
			case 1: 
				HeadsetController.listar();
				break;
			case 2:
				HeadsetController.cadastrar();
				break;
			case 3: 
				HeadsetController.excluir();
				break;
			case 4:
				HeadsetController.atualizar();
				break;
			case 5: 
				TelaPrincipal.mostrar();
				break;
		}
			break;
		case 3:
			opcao = 0;
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] "+Mensagem.MSG_LISTAR);
			System.out.println("[2] "+Mensagem.MSG_CADASTRAR);
			System.out.println("[3] "+Mensagem.MSG_EXCLUIR);
			System.out.println("[4] "+Mensagem.MSG_ALTERACAO);
			System.out.println("[5] "+Mensagem.MSG_VOLTAR);
			opcao = leitor.nextInt();

			
			switch(opcao) {
			case 1: 
				MouseController.listar();
				break;
			case 2:
				MouseController.cadastrar();
				break;
			case 3: 
				MouseController.excluir();
				break;
			case 4:
				MouseController.atualizar();
				break;
			case 5: 
				TelaPrincipal.mostrar();
				break;
		}
			break;
		case 4:
			TelaPrincipal.mostrar();
		}


	}
	}
