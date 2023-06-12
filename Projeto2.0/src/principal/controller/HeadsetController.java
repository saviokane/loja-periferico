package principal.controller;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Scanner;

import principal.daos.DAO;
import principal.model.Headset;
import principal.tela.TelaDeProdutos;
import projeto.loja.util.Mensagem;
import principal.daos.HeadsetDAO;

public class HeadsetController {

	private static DAO<Headset> dao = new HeadsetDAO();
	
	public static void listar() {
		List<Headset> headsets = dao.listar();
		System.out.println("\nLista de Headsets cadastrados:\n");

		for(Headset headset : headsets) {
			System.out.println(Mensagem.SEPARADOR);
			System.out.println("Marca: "+ headset.getMarca());
			System.out.println("Nome: "+ headset.getNome());
			System.out.println("Valor: "+ headset.getValor());
			System.out.println("Drivers: "+ headset.getDrivers());
			System.out.println("Modelo: "+ headset.getModelo());
			System.out.println("Conectores: "+ headset.getConectores());
		}
		
		TelaDeProdutos.mostrar();
	}
	
	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println(Mensagem.ADD_HEADSET);
		System.out.println();
		
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_DRIVERS);
		String drivers = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_MODELO);
		String modelo = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_CONECTORES);
		String conectores = leitor.nextLine();
		
		Headset headset = new Headset(marca, nome, valor, drivers, modelo, conectores);
		
		dao.salvar(headset);
		
		TelaDeProdutos.mostrar();
		leitor.close();
	}
	
	public static void atualizar() {
		
		List<Headset> headsets = dao.listar();
	   	List<Integer> idshed = dao.obterTodosIds();
	   	for (int i = 0 ; i < headsets.size(); i++) {
   		Headset headset = headsets.get(i);
   		int heasetId = idshed.get(i);
	    	
			System.out.println(Mensagem.SEPARADOR);
			System.out.println("ID: "+heasetId);
			System.out.println("Marca: " + headset.getMarca());
			System.out.println("Nome: " + headset.getNome());
			System.out.println("Valor: " + headset.getValor());
			System.out.println("Drivers: " + headset.getConectores());
			System.out.println("Modelo: " + headset.getModelo());
			System.out.println("Conectores: " + headset.getDrivers());
			System.out.println(Mensagem.SEPARADOR);
		}
	   	
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione qual produto deseja alterar: ");
		int id = leitor.nextInt();
		
		Headset headsetAtualizado = dao.buscarPorId(id);
		System.out.println(Mensagem.SEPARADOR);
		
		System.out.println(Mensagem.CADASTRA_MARCA);
		String marca = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_NOME);
		String nome = leitor.nextLine();
		
		System.out.println(Mensagem.VALOR_PRODUTO);
		String valor = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_DRIVERS);
		String drivers = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_MODELO);
		String modelo = leitor.nextLine();
		
		System.out.println(Mensagem.CADASTRA_CONECTORES);
		String conectores = leitor.nextLine();
		
		headsetAtualizado.setMarca(marca);
		headsetAtualizado.setNome(nome);
		headsetAtualizado.setValor(valor);
		headsetAtualizado.setDrivers(drivers);
		headsetAtualizado.setModelo(modelo);
		headsetAtualizado.setConectores(conectores);
		
		dao.atualizar(headsetAtualizado);
		
		TelaDeProdutos.mostrar();
		
	}
	
	public static void excluir() {
		
		List<Headset> headsets = dao.listar();
	   	List<Integer> idshed = dao.obterTodosIds();
	   	for (int i = 0 ; i < headsets.size(); i++) {
   		Headset headset = headsets.get(i);
   		int heasetId = idshed.get(i);
	    	
			System.out.println(Mensagem.SEPARADOR);
			System.out.println("ID: "+heasetId);
			System.out.println("Marca: " + headset.getMarca());
			System.out.println("Nome: " + headset.getNome());
			System.out.println("Valor: " + headset.getValor());
			System.out.println("Drivers: " + headset.getConectores());
			System.out.println("Modelo: " + headset.getModelo());
			System.out.println("Conectores: " + headset.getDrivers());
			System.out.println(Mensagem.SEPARADOR);
		}
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione qual produto deseja remover: ");
		int id = leitor.nextInt();
		leitor.nextLine();
		
		dao.excluir(id);
		
		TelaDeProdutos.mostrar();
		
	}
	
}
//Colocar as listas para selecionar quando for atualizar e tbm arrumar as mensagens !
