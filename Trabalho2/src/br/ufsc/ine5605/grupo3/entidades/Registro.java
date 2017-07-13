package br.ufsc.ine5605.grupo3.entidades;

import br.ufsc.ine5605.grupo3.controladores.GeradorId;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

import javax.swing.*;
import java.io.Serializable;

public class Registro implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer data;
	private Integer mes;
	private Integer hora;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private boolean motivo;
	private Integer kmAndados;
	private String mensagem;

	public Registro(Integer data, Integer mes, Integer hora, Funcionario funcionario, Veiculo veiculo, boolean motivo, String mensagem) {
		this.id = GeradorId.getNextRegisterID();
		this.data = data;
		this.mes = mes;
		this.hora = hora;
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}


	public Integer getData() {
		return this.data;
	}

	public Integer getMes(){
		return this.mes;
	}


	public void setData(Integer data) {
		this.data = data;
	}


	public Integer getHora() {
		return this.hora;
	}


	public void setHora(Integer hora) {
		this.hora = hora;
	}


	public Funcionario getFuncionario() {
		return this.funcionario;
	}


	public void setFuncionario(Funcionario f) {
		this.funcionario = f;
	}


	public Veiculo getVeiculo() {
		return this.veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public boolean getMotivo() {
		return this.motivo;
	}

	public String getTipoMotivo(){
		if(this.getMotivo()){
			return Messages.PERMISSAO;
		} else {
			return Messages.NEGACAO;
		}
	}


	public void setMotivo(boolean motivo) {
		this.motivo = motivo;
	}


	public Integer getKmAndados() {
		return this.kmAndados;
	}


	public void setKmAndados(Integer kmAndados) {
		this.kmAndados = kmAndados;
	}


	public String getMensagem() {
		return this.mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getMesDoAno(){
		String mesDoAno = null;
		switch (this.getMes()) {
		case 1:
			mesDoAno = "Janeiro";
			break;
		case 2:
			mesDoAno = "Fevereiro";
			break;
		case 3:
			mesDoAno = "Março";
			break;
		case 4:
			mesDoAno =  "Abril";
			break;
		case 5:
			mesDoAno =  "Maio";
			break;
		case 6:
			mesDoAno = "Junho";
			break;
		case 7:
			mesDoAno =  "Julho";
			break;
		case 8:
			mesDoAno =  "Agosto";
			break;
		case 9:
			mesDoAno =  "Setembro";
			break;
		case 10:
			mesDoAno =  "Outubro";
			break;
		case 11:
			mesDoAno = "Novembro";
			break;
		case 12:
			mesDoAno = "Dezembro";
			break;
		default:
			error();
			break;
		}

		return mesDoAno;
	}

	private void error() {
		JOptionPane.showMessageDialog(null, Messages.NAO);
	}
}
