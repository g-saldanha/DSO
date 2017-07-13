package br.ufsc.ine5605.grupo3.entidades;

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

	public Registro(Long id, Integer data, Integer mes, Integer hora, Funcionario funcionario, Veiculo veiculo, boolean motivo, String mensagem) {
		this.id = id;
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
		String mes = null;
		switch (this.getMes()) {
		case 1:
			mes"Janeiro";
			break;
		case 2:
			mes = "Fevereiro";
			break;
		case 3:
			mes = "Março";
			break;
		case 4:
			mes =  "Abril";
			break;
		case 5:
			mes =  "Maio";
			break;
		case 6:
			mes = "Junho";
			break;
		case 7:
			mes =  "Julho";
			break;
		case 8:
			mes =  "Agosto";
			break;
		case 9:
			mes =  "Setembro";
			break;
		case 10:
			mes =  "Outubro";
			break;
		case 11:
			mes = "Novembro";
			break;
		case 12:
			mes = "Dezembro";
			break;
		default:
			error();
			break;
		}

		return mes;
	}

	private void error() {
		JOptionPane.showMessageDialog(null, Messages.NAO);
	}
}
