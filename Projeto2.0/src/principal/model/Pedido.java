package principal.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// para puxar todas as informações de pedido e 
//	@OneToOne
//	@JoinColumn(name = "id_produto")
//	private Produto produtoz;
	
	private String produto;
	private String valor;
	private String nome;
	private String cpf;
	private String telefone;

	
	 public Pedido() {
	        
	    }
	public Pedido(String produto,String valor, String nome, String cpf, String telefone) {
		this.produto = produto;
		this.valor = valor;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
	


	

}
