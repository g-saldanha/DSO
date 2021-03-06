/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caio
 */
public class Funcionario {
	private Integer numeroMatricula;
	private String nome;
	private Integer dataNascimento;
	private Integer telefone;

	public enum Cargo {
		DIRETORIA, COMUM
	};
	Cargo cargo;
	boolean bloqueado = false;
	private ArrayList<Veiculo> tiposDeVeiculo;
	private Chave chave;

	public Funcionario(Integer numeroMatricula, String nome, Integer dataNascimento, Integer telefone, Cargo cargo,
					   ArrayList<Veiculo> tiposDeVeiculo) {
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cargo = cargo;
		this.tiposDeVeiculo = tiposDeVeiculo;
	}

	public Integer getNumeroMatricula() {
		return this.numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Integer dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Veiculo> getTiposDeVeiculo() {
		return this.tiposDeVeiculo;
	}

	public void setTiposDeVeiculo(ArrayList<Veiculo> tiposDeVeiculo) {
		this.tiposDeVeiculo = tiposDeVeiculo;
	}

	public Chave getChave() {
		return this.chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public void adicionarTipoDeVeiculo(Veiculo veiculo) {
		if (!this.tiposDeVeiculo.contains(veiculo)) {
			this.tiposDeVeiculo.add(veiculo);
		}
	}

	public boolean checaPlacas(Chave c) {
		for (Veiculo veiculo : this.tiposDeVeiculo) {
			if (c.getPlaca().equals(veiculo.getPlaca())) {
				return true;
			}
		}
		return false;
	}

	public boolean getBloqueado() {
		return this.bloqueado;
	}

	public void bloquear() {
		this.bloqueado = true;
	}

	public void desbloquear() {
		this.bloqueado = false;

	}
}
