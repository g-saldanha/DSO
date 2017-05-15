package br.ufsc.ine5605.grupo3.entidades;

public class Carro extends Veiculo{
	
	
	public Carro(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 2;
	}

	

}
