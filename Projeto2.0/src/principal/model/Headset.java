package principal.model;

import jakarta.persistence.*;

@Entity
public class Headset extends Produto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String drivers;
	private String modelo;
	private String conectores;
	
	public Headset() {
		
	}
	
	public Headset(String marca, String nome, String valor, String drivers, String modelo, String conectores) {
		super(marca, nome, valor);
		this.drivers = drivers;
		this.modelo = modelo;
		this.conectores = conectores;
	}

	public String getDrivers() {
		return drivers;
	}

	public void setDrivers(String drivers) {
		this.drivers = drivers;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getConectores() {
		return conectores;
	}

	public void setConectores(String conectores) {
		this.conectores = conectores;
	}
	
	
	
}
