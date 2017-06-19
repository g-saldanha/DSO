package br.ufsc.ine5605.grupo3.entidades;

import java.io.Serializable;

public class Carro extends Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public Carro(String placa, String modelo, String marca, Integer ano, Integer km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = Tipo.CARRO;
	}

	

}
