package br.ufsc.ine5605.entidades;

public class Carro extends Veiculo{
	private int tipo;
	
	public Carro(String placa, String modelo, String marca, int ano, int km) {
		super(placa, modelo, marca, ano, km);
		this.tipo = 2;
	}

	@Override
	Veiculo pegaVeiculo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

}
