package br.ufsc.ine5605.entidades;

import java.util.Date;
import java.util.Timer;

public class Registro {
	private Date data;
	private Timer hora;
	private int matricula;
	private Veiculo veiculo;
	private boolean motivo;
	private int kmAndados;
	private String mensagem;
	
	public Registro(Date data, Timer hora, int matricula, Veiculo veiculo, boolean motivo, int kmAndados, String mensagem) {
		super();
		this.data = data;
		this.hora = hora;
		this.matricula = matricula;
		this.veiculo = veiculo;
		this.motivo = motivo;
		this.kmAndados = kmAndados;
		this.mensagem = mensagem;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Timer getHora() {
		return hora;
	}


	public void setHora(Timer hora) {
		this.hora = hora;
	}


	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public boolean getMotivo() {
		return motivo;
	}


	public void setMotivo(boolean motivo) {
		this.motivo = motivo;
	}


	public int getKmAndados() {
		return kmAndados;
	}


	public void setKmAndados(int kmAndados) {
		this.kmAndados = kmAndados;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
