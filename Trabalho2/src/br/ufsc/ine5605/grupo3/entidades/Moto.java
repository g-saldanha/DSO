package br.ufsc.ine5605.grupo3.entidades;

import java.io.Serializable;

public class Moto extends Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;

	public Moto(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = Tipo.MOTO;
	}
	


}
