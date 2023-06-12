package principal;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import principal.controller.ClienteController;
import principal.tela.TelaPrincipal;

public class Programa {

	public static void main(String[] args) {

		TelaPrincipal.mostrar();		

	}
}
		


//static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex_mysql");
//static EntityManager em = emf.createEntityManager();
//menu();

//	}
//		public static void menu() {
//		int opcao ;
//		Scanner leitor = new Scanner(System.in);
		
		
		
//		configuração do JPA
		
	
		
//	
//		
//		System.out.println("informe");
//		opcao= leitor.nextInt();
		//gravação de pessoa no db
		
//		switch (opcao) {
		
//		case 1:}
			
			
//			Pessoa pessoa = new Pessoa("vitoria","123456");
//			salvar(pessoa);
			
		
//		break;
//		
//		case 2:
//			
//			List<Pessoa>lista = listar();
//			for(Pessoa pessoa1 : lista) {
//				System.out.println("id: " + pessoa1.getId() +" nome: " + pessoa1.getNome() + " cpf: " + pessoa1.getCpf() );
//				
//			}
//			menu();
//			
//			break;
//
//		case 3:
//			
//			Pessoa p2 = buscar(1);
//			System.out.println("id: " + p2.getId() +" nome: " + p2.getNome() + " cpf: " + p2.getCpf() );
//			menu();
//			
//			break;
//		case 4:
//			System.out.println("qual deseja excluir:");
//			List<Pessoa>lista1 = listar();
//			for(Pessoa pessoa1 : lista1) {
//				System.out.println("id: " + pessoa1.getId() +" nome: " + pessoa1.getNome() + " cpf: " + pessoa1.getCpf() );
//				
//			}
//			opcao = leitor.nextInt();
//			excluir(opcao);
//		
//			break;
//		case 5:
//			
//			Pessoa pessoaParaAtualizar = buscar(1); // Busca a pessoa que deseja atualizar
//			pessoaParaAtualizar.setNome("Novo nome"); // Modifica o nome da pessoa
//			pessoaParaAtualizar.setCpf("Novo CPF"); // Modifica o CPF da pessoa
//			atualizar(pessoaParaAtualizar); // Atualiza a pessoa no banco de dados
//
//			
//			break;
//			
//		}
//
//		
//}
//	public static void excluir(Integer id) {
//		
//		
//		Pessoa p = em.find(Pessoa.class, id);
//		em.getTransaction().begin();
//		em.remove(p);
//		em.getTransaction().commit();
//		System.out.println("Excluido com sucesso: " + p.getNome());
//		
//		menu();
//		
//	}
//	
//	public static Integer atualizar(Pessoa pessoa) {
//		//Atualização da pessoa no banco de dados
//		em.getTransaction().begin();
//		em.merge(pessoa);
//		em.getTransaction().commit();
//		menu();
//		return pessoa.getId();
//		
//	}
//
//	public static Pessoa buscar(Integer id) {
//		Pessoa pessoa =em.find(Pessoa.class, id);
//		return pessoa;
//		
//	}
//	
//	
//	public static List<Pessoa> listar(){
//		List<Pessoa> Lista= em.createQuery("from Pessoa", Pessoa.class).getResultList();
//		return Lista;
//		
//		
//	}
//	
//	public static Integer salvar(Pessoa pessoa) {
//
//		//gravação de pessoa no db
//		em.getTransaction().begin();
//		em.persist(pessoa);
//		em.getTransaction().commit();
//		menu();
//		return pessoa.getId();
//		
//	
//		
//	}
