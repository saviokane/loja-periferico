package principal.controller;

import java.util.List;
import java.util.Scanner;

import principal.daos.DAO;
import principal.model.Teclado;
import principal.tela.TelaDeProdutos;
import projeto.loja.util.Mensagem;
import principal.daos.TecladoDAO;

public class TecladoController {

	private static DAO<Teclado> dao = new TecladoDAO();
	
	public static void listar(){

		List<Teclado> teclados = dao.listar();
		System.out.println("\nLista de Teclados cadastrados:\n");
		for (Teclado teclado : teclados) {
			System.out.println(Mensagem.SEPARADOR);
			System.out.println("Marca: " + teclado.getMarca());
			System.out.println("Nome: " + teclado.getNome());
			System.out.println("Valor: " + teclado.getValor());
			System.out.println("SwitchType: " + teclado.getSwitchType());
			System.out.println("modelo: " + teclado.getModelo());
			System.out.println("Layout: " + teclado.getLayout());
			
		}
		TelaDeProdutos.mostrar();
	}

	public static void cadastrar() {
		
		Scanner leitor = new Scanner(System.in);
		System.out.println(Mensagem.ADD_TECLADO);
		System.out.println();
		
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_SWITCHTYPE);
		String switchtype = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_MODELO);
		String modelo = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_LAYOUT);
		String layout = leitor.nextLine();
		
		Teclado teclado = new Teclado(marca, nome, valor, switchtype, modelo, layout);
		
		dao.salvar(teclado);
		System.out.println("Produto cadastrado!!");
		
		TelaDeProdutos.mostrar();
		leitor.close();
	}

	public static void atualizar() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione qual produto deseja alterar: ");
		int id = leitor.nextInt();
				
		Teclado tecladoAtualizado = dao.buscarPorId(id);
		
		leitor.nextLine();
		System.out.println(Mensagem.SEPARADOR);
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_SWITCHTYPE);
		String switchtype = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_MODELO);
		String modelo = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_LAYOUT);
		String layout = leitor.nextLine();
		
		tecladoAtualizado.setMarca(marca);
		tecladoAtualizado.setNome(nome);
		tecladoAtualizado.setValor(valor);
		tecladoAtualizado.setSwitchType(switchtype);
		tecladoAtualizado.setModelo(modelo);
		tecladoAtualizado.setLayout(layout);
		
		dao.atualizar(tecladoAtualizado);
		
		TelaDeProdutos.mostrar();
		
	}
	
	public static void excluir() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione qual produto deseja remover: ");
		int id = leitor.nextInt();
		leitor.nextLine();
		
		dao.excluir(id);
		
		TelaDeProdutos.mostrar();
	}
	

}
//Colocar as listas para selecionar quando for atualizar e tbm arrumar as mensagens !
