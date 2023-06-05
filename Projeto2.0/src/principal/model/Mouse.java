package principal.model;

import jakarta.persistence.*;

@Entity
public class Mouse extends Produto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dpi;
	private String peso;
	private String tempoResposta;
	
	public Mouse() {
		
	}
	
	public Mouse(String marca, String nome, String valor, String dpi, String peso, String tempoResposta) {
		super(marca, nome, valor);
		
		this.dpi = dpi;
		this.peso = peso;
		this.tempoResposta = tempoResposta;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(String tempoResposta) {
		this.tempoResposta = tempoResposta;
	}
	
	
}
