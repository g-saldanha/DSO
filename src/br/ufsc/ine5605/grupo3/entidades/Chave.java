/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.entidades;

/**
 *
 * @author 08801473931
 */
public class Chave {
    private String placa;
	private boolean isAlugada;
	
	
	public Chave(String placa) {
		this.placa = placa;
		this.isAlugada = false;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public boolean isAlugada() {
		return isAlugada;
	}
	public void setAlugada(boolean isAlugada) {
		this.isAlugada = isAlugada;
	}
    
}
