package principal.model;

import jakarta.persistence.*;

@Entity
public class Teclado extends Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String switchType;
	private String modelo;
	private String layout;
	
	public Teclado() {
		
	}
	
	public Teclado(String marca, String nome, String valor,String switchType, String modelo, String layout) {
		super(marca,  nome,  valor);
		this.switchType = switchType;
		this.modelo = modelo;
		this.layout = layout;
	}
	
	public String getSwitchType() {
		return switchType;
	}



	public void setSwitchType(String switchType) {
		this.switchType = switchType;
	}



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getLayout() {
		return layout;
	}



	public void setLayout(String layout) {
		this.layout = layout;
	}
}
