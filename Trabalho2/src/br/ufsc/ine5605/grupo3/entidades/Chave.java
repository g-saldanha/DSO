/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.entidades;

import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.controladores.GeradorId;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author 08801473931
 */
public class Chave implements Serializable {

	private static final long serialVersionUID = 1L;
    private String placa;
	private boolean isAlugada;
	private Long id;


	public Chave(String placa) {
		this.placa = placa;
		this.isAlugada = false;
		this.id = GeradorId.getNextID();
	}

	public String getPlaca() {
		return this.placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public boolean isAlugada() {
		return this.isAlugada;
	}
	public void setAlugada(boolean isAlugada) {
		this.isAlugada = isAlugada;
	}

	public String getEstado() {
		if(this.isAlugada) {
			return Messages.SIM;
		} else {
			return Messages.NAO;
		}
	}

    public String getModelo() throws IOException {
	    Veiculo v = ControladorPrincipal.getInstance().pegaVeiculo(getPlaca());
        return v.getModelo();
    }

	public Long getID() {
		return this.id;
	}
}
