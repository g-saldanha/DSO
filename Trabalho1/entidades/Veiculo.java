package Trabalho1.entidades;

public class Veiculo {
	private int id;
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private int km;
	
	public Veiculo(String placa, String modelo, String marca, int ano, int km){
		this.placa = placa;
		this. modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.km = km;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	
}
