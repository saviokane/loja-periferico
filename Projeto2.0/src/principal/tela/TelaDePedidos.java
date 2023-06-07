package principal.tela;

import java.util.Scanner;

import principal.controller.PedidoController;
import projeto.loja.util.Mensagem;

public class TelaDePedidos {
	
	public static void mostrar() {
		
	Scanner leitor = new Scanner(System.in);

//	tem que arrumar aqui tbm meu parça !!
	
	System.out.println(Mensagem.TELA_PEDIDOS);
	System.out.println(Mensagem.MSG_ESCOLHA);
	System.out.println("[1] "+"Realizar pedido.");
	System.out.println("[2] "+"Listar pedidos");
	System.out.println("[3] "+Mensagem.MSG_VOLTAR);
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
		TelaPrincipal.mostrar();
		break;
	}
	leitor.close();
	
}
}