/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacao.TelaFuncionario;
import br.ufsc.ine5605.grupo3.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio
 */
public class ControladorFuncionario {

	private TelaFuncionario telaFuncionario;
	private ArrayList<Funcionario> funcionarios;
	private static ControladorFuncionario instance;

	private ControladorFuncionario() {
		this.funcionarios = new ArrayList<>();
		this.telaFuncionario = new TelaFuncionario(this);
	}

	public static ControladorFuncionario getInstance() {
		if (instance == null) {
			instance = new ControladorFuncionario();
		}

		return instance;
	}

	public void cadastraFuncionario(Funcionario f){
		try {
			this.verificaMatricula(f.getNumeroMatricula());
		} catch (CadastroIncorretoException e) {
			System.out.println("Funcionario Existente");
			return;
		}
		this.funcionarios.add(f);
	}

	public void cadastraFuncionario(int numeroMatricula, String nome, int dataNascimento, int telefone, Cargo cargo,
			ArrayList<Veiculo> tiposDeVeiculo) {
		try {
			this.verificaMatricula(numeroMatricula);
		} catch (CadastroIncorretoException e) {
			System.out.println("Funcionario Existente");
			return;
		}

		Funcionario novoFuncionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo,
				tiposDeVeiculo);

		this.funcionarios.add(novoFuncionario);
	}

	public void excluiFuncionario(Funcionario funcionario) {
		if (funcionario != null && this.funcionarios.contains(funcionario)) {
			if(funcionario.getChave() == null){
				System.out.println("Funcionario com chave não pode ser excluido");
				return;
			}
			this.funcionarios.remove(funcionario);
		}
	}

	public Funcionario getFuncionario(int numeroMatricula) {
		for (Funcionario funcionario : this.funcionarios) {
			if (funcionario.getNumeroMatricula() == numeroMatricula) {
				return funcionario;
			}
		}
		return null;
	}

	public boolean haFuncionarios() {
		if (this.funcionarios.isEmpty()) {
			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return false;
		}
		return true;
	}

	public void exibeFuncionariosCadastrados() {
		if (this.funcionarios.isEmpty()) {
			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return;
		}
		for (Funcionario funcionario : this.funcionarios) {
			this.telaFuncionario.exibeFuncionario(funcionario);
		}
	}

	public void exibeTelaFuncionario() {
		this.telaFuncionario.exibirTela();
	}

	public void verificaMatricula(int matricula) throws CadastroIncorretoException {
		for (Funcionario funcionario : this.funcionarios) {
			if (funcionario.getNumeroMatricula() == matricula) {
				throw new CadastroIncorretoException("matricula existente!");
			}
		}
	}

	public Veiculo pegaVeiculo(String opt) {
		return ControladorPrincipal.getInstance().pegaVeiculo(opt);
	}

	public static void bloquearFuncionario(Funcionario f) {
		f.bloquear();
	}

	public static void desbloqueia(Funcionario blok) {
		blok.desbloquear();

	}

}
