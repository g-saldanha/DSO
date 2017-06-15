package br.ufsc.ine5605.grupo3.entidades;

public class Caminhonete extends Veiculo {
	
	
	public Caminhonete(String placa, String modelo, String marca, Integer ano, Integer km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 3;
	}

	

}
