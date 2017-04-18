package Trabalho1.entidades;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private int id;
	private int numeroMatricula;
	private String nome;
	private int dataNascimento;
	private int telefone;
	private String cargo;
	private List<Veiculo> tiposDeVeiculo;
	
	public Funcionario(int id, int numeroMatricula, String nome, int dataNascimento, int telefone, String cargo) {
		this.id = id;
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cargo = cargo;
		this.tiposDeVeiculo = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
