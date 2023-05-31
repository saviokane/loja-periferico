package principal.controller;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;

import principal.daos.DAO;
import principal.model.Teclado;
import principal.tela.TelaDeProdutos;
import principal.daos.TecladoDAO;

public class TecladoController {

	private static DAO<Teclado> dao = new TecladoDAO();
	
	public static void listar(){
		System.out.println("Lista!");
		List<Teclado> teclados = dao.listar();
		
		for (Teclado teclado : teclados) {
			System.out.println("Tipo:");
			System.out.println("Marco:");
			System.out.println("Nome:");
			System.out.println("Valor:");
			System.out.println("SwitchType:");
			System.out.println("modelo:");
			System.out.println("Layout:");
		}
		TelaDeProdutos.mostrar();
	}
}
