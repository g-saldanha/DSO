package br.ufsc.ine5605.entidades;

public class Moto extends Veiculo {

	public Moto(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 1;
	}
	


}
