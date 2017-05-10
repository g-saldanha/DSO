package br.ufsc.ine5605.entidades;

public class Moto extends Veiculo {
	private int tipo;

	public Moto(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 1;
	}

	@Override
	Veiculo pegaVeiculo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
