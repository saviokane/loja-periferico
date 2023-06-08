package principal.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@OneToOne
	@JoinColumn(name = "id_produto")
	private Teclado teclado;
	
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	
	
	 public Pedido() {
	        
	    }
	 
	public Pedido(Teclado teclado, Pessoa pessoa) {
		super();
		this.teclado = teclado;
		this.pessoa = pessoa;
	}



	public Teclado getTeclado() {
		return teclado;
	}



	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
	
	 