/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.controladores;

import java.util.ArrayList;

import br.ine5605.ufsc.apresentacao.TelaFuncionario;
import br.ine5605.ufsc.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.entidades.Funcionario;
import br.ufsc.ine5605.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.entidades.Veiculo;

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
		if (instance == null)
			instance = new ControladorFuncionario();

		return instance;
	}

	public void cadastraFuncionario(int numeroMatricula, String nome, int dataNascimento, int telefone, Cargo cargo,
			ArrayList<Veiculo> tiposDeVeiculo) {
		try {
			verificaMatricula(numeroMatricula);
		} catch (CadastroIncorretoException e) {
			System.out.println("Funcionario Existente");
			return;
		}

		Funcionario novoFuncionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo,
				tiposDeVeiculo);

		funcionarios.add(novoFuncionario);
	}

	public void excluiFuncionario(Funcionario funcionario) {
		if (funcionario != null && funcionarios.contains(funcionario)) {
			if(funcionario.getChave() == null){
				System.out.println("Funcionario com chave não pode ser excluido");
				return;
			}
			funcionarios.remove(funcionario);
		}
	}

	public Funcionario getFuncionario(int numeroMatricula) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNumeroMatricula() == numeroMatricula) {
				return funcionario;
			}
		}
		return null;
	}

	public boolean haFuncionarios() {
		if (funcionarios.isEmpty()) {
			telaFuncionario.mensagemNaoHaFuncionarios();
			return false;
		}
		return true;
	}

	public void exibeFuncionariosCadastrados() {
		if (funcionarios.isEmpty()) {
			telaFuncionario.mensagemNaoHaFuncionarios();
			return;
		}
		for (Funcionario funcionario : this.funcionarios) {
			telaFuncionario.exibeFuncionario(funcionario);
		}
	}

	public void exibeTelaFuncionario() {
		telaFuncionario.exibirTela();
	}

	public void verificaMatricula(int matricula) throws CadastroIncorretoException {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNumeroMatricula() == (matricula)) {
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

	public void desbloqueia(Funcionario blok) {
		blok.desbloquear();
		
	}

}
