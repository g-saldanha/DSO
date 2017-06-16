package br.ufsc.ine5605.grupo3.entidades;

public class Moto extends Veiculo {

	public Moto(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = Tipo.MOTO;
	}
	


}
