package principal.controller;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Scanner;

import principal.daos.DAO;
import principal.model.Mouse;
import principal.tela.TelaDeProdutos;
import projeto.loja.util.Mensagem;
import principal.daos.MouseDAO;

public class MouseController {

	private static DAO<Mouse> dao = new MouseDAO();
	
	public static void listar() {
		System.out.println("Lista de Mouses cadastrados: ");
		List<Mouse> mouses = dao.listar();
		
		for(Mouse mouse : mouses) {
			System.out.println(Mensagem.SEPARADOR);
			System.out.println("Marca: "+ mouse.getMarca());
			System.out.println("Nome: "+ mouse.getNome());
			System.out.println("Valor: "+ mouse.getValor());
			System.out.println("DPI: "+ mouse.getDpi());
			System.out.println("Peso: "+ mouse.getPeso());
			System.out.println("Tempo de Resposta: "+ mouse.getTempoResposta());
		}
		
		TelaDeProdutos.mostrar();
	}
	
	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println(Mensagem.ADD_MOUSE);
		System.out.println();
		
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_DPI);
		String dpi = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_PESO);
		String peso = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_TEMPORESPOSTA);
		String tempoResposta = leitor.nextLine();
		
		
		Mouse mouse = new Mouse(marca, nome, valor, dpi, peso, tempoResposta);
		
		dao.salvar(mouse);
		
		TelaDeProdutos.mostrar();
		
		leitor.close();
		
	}
	
	
	public static void atualizar() {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione qual produto deseja alterar: ");
		int id = leitor.nextInt();
		
		Mouse mouseAtualizado = dao.buscarPorId(id);
		System.out.println(Mensagem.SEPARADOR);
		
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_DPI);
		String dpi = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_PESO);
		String peso = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_TEMPORESPOSTA);
		String tempoResposta = leitor.nextLine();
		
		mouseAtualizado.setMarca(marca);
		mouseAtualizado.setNome(nome);
		mouseAtualizado.setValor(valor);
		mouseAtualizado.setDpi(dpi);
		mouseAtualizado.setPeso(peso);
		mouseAtualizado.setTempoResposta(tempoResposta);
		
		dao.atualizar(mouseAtualizado);
		
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
