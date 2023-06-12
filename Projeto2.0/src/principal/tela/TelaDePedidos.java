package principal.tela;

import java.util.Scanner;

import principal.controller.PedidoController;
import principal.model.Pedido;
import projeto.loja.util.Mensagem;

public class TelaDePedidos {
	
	public static void mostrar() {
		
	Scanner leitor = new Scanner(System.in);

//	tem que arrumar aqui tbm meu parça !!
	
	System.out.println(Mensagem.TELA_PEDIDOS);
	System.out.println(Mensagem.MSG_ESCOLHA);
	System.out.println("[1] "+"Cadastrar ");
	System.out.println("[2] "+"Listar ");
	System.out.println("[3] "+"Excluir ");
	System.out.println("[4] "+"Atualizar");
	System.out.println("[5] "+"Voltar");
	int escolha = leitor.nextInt();
	leitor.nextLine();

	switch(escolha) {
	case 1:
		PedidoController.cadastrar();
		break;
	case 2:
		PedidoController.listar();
		break;
	case 3:
		PedidoController.excluir();
		break;
	case 4:
		PedidoController.atualizar();
		break;
	case 5:
		TelaPrincipal.mostrar();
		break;
	}
	leitor.close();
	
}
}