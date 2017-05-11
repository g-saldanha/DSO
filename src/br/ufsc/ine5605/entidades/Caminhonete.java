package br.ufsc.ine5605.entidades;

public class Caminhonete extends Veiculo {
	
	
	public Caminhonete(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 3;
	}

	

}
