package principal.tela;

import java.util.Scanner;

import principal.controller.TecladoController;
import projeto.loja.util.Mensagem;

public class TelaDeProdutos {
	public static void mostrar() {
		
		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
	
		
		System.out.println(Mensagem.TELA_PRODUTOS);
		System.out.println();
		System.out.println("Selectione :");
		System.out.println(Mensagem.TELA_TECLADO);
		System.out.println(Mensagem.TELA_HEADSET);
		System.out.println(Mensagem.TELA_MOUSE);
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
			leitor.close();
			
		}
		}


}
