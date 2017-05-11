/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.entidades;

/**
 *
 * @author Caio
 */
public class Veiculo {
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private int km;
	protected int tipo;
	
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
	
	public int getTipo(){
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
