/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caio
 */
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer numeroMatricula;
	private String nome;
	private Integer dataNascimento;
	private Integer telefone;
	private Cargo cargo;
	boolean bloqueado = false;
	private List<Veiculo> tiposDeVeiculo;
	private Chave chave;
	private int counter = 0;

	public Funcionario(Integer numeroMatricula, String nome, Integer dataNascimento, Integer telefone, Cargo cargo) {
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cargo = cargo;
		this.tiposDeVeiculo = new ArrayList<>();
	}

	public Funcionario(Integer i, String string, Integer j, Integer k, Cargo cargo2, List<Veiculo> veiculos) {
		this.numeroMatricula = i;
		this.nome = string;
		this.dataNascimento = j;
		this.telefone = k;
		this.cargo = cargo2;
		this.tiposDeVeiculo = veiculos;
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

	public void setTiposDeVeiculo(List<Veiculo> tiposDeVeiculo) {
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

	public void addCounter() {
		this.counter ++;
		if(this.counter >= 3){
			this.bloquear();
		}

	}

	public void resetCounter() {
		this.counter = 0;

	}

}


