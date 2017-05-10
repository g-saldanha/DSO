/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caio
 */
public class Funcionario {
 	private int numeroMatricula;
 	private String nome;
 	private int dataNascimento;
 	private int telefone;
 	private enum cargo{DIRETORIA, COMUM};
 	private ArrayList<Veiculo> tiposDeVeiculo;
 	
 	public Funcionario(int numeroMatricula, String nome, int dataNascimento, int telefone, String cargo) {	
 		this.numeroMatricula = numeroMatricula;
 		this.nome = nome;
 		this.dataNascimento = dataNascimento;
 		this.telefone = telefone;
 		this.cargo = cargo;
 		this.tiposDeVeiculo = new ArrayList<>();
	}

 
 	public int getNumeroMatricula() {
 		return numeroMatricula;
 	}
 
 	public void setNumeroMatricula(int numeroMatricula) {
 		this.numeroMatricula = numeroMatricula;
 	}
 
 	public String getNome() {
 		return nome;
 	}
 
 	public void setNome(String nome) {
 		this.nome = nome;
 	}
 
 	public int getDataNascimento() {
 		return dataNascimento;
 	}
 
 	public void setDataNascimento(int dataNascimento) {
 		this.dataNascimento = dataNascimento;
 	}
 
 	public int getTelefone() {
 		return telefone;
 	}
 
 	public void setTelefone(int telefone) {
 		this.telefone = telefone;
 	}
 
 	public String getCargo() {
 		return cargo;
 	}
 
 	public void setCargo(String cargo) {
 		this.cargo = cargo;
 	}
 
 	public List<Veiculo> getTiposDeVeiculo() {
 		return tiposDeVeiculo;
 	}
 
 	public void setTiposDeVeiculo(ArrayList<Veiculo> tiposDeVeiculo) {
 		this.tiposDeVeiculo = tiposDeVeiculo;
 	}
 	
 	
 	
 
 }

