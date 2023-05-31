package principal.tela;

import java.util.Scanner;

import principal.controller.ClienteController;
import projeto.loja.util.Mensagem;

public class TelaDeClientes {

	public static void mostrar() {
		
		Scanner leitor = new Scanner(System.in);
		int opcao;
		
		System.out.println(Mensagem.TELA_CLIENTES);
		System.out.println(Mensagem.MSG_ESCOLHA);
		System.out.println("[1] "+Mensagem.MSG_LISTAR);
		System.out.println("[2] "+Mensagem.MSG_CADASTRAR);
		System.out.println("[3] "+Mensagem.MSG_EXCLUIR);
		System.out.println("[4] "+Mensagem.MSG_ALTERACAO);
		System.out.println("[5] "+Mensagem.MSG_VOLTAR);
		opcao = leitor.nextInt();
		switch(opcao) {
		case 1:
			ClienteController.listar();
			break;
		case 2:
			ClienteController.cadastrar();
			break;
		case 3:
			ClienteController.excluir();
			break;
		case 4:
			ClienteController.atualizar();
			break;
		case 5:
			TelaPrincipal.mostrar();
			break;}
		leitor.close();
	}
}
