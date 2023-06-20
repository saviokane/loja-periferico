package principal.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@JoinColumn(name="nome_cliente")
	private String cliente;
	
	@Column(name="valor_produto")
	private String valor;
	
	public Pedido() {}

	
	public Pedido(Pessoa pessoa, Produto produto) {
		this.pessoa = pessoa;
		this.produto = produto;
		this.cliente= produto.getNome();
		this.valor = produto.getValor();
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProdutos() {
		return produto;
	}

	public void setProdutos(Produto produto) {
		this.produto = produto;
	}
	

	
	
	
	
	
	


}
	
	 