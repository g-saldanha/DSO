/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaFuncionarios;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio & Gabriel
 */
public class ControladorFuncionario {

	private TelaFuncionarios telaFuncionarios;
	private FuncionarioDAO funcionarios;
	private static ControladorFuncionario instance;

	private ControladorFuncionario() {
		this.telaFuncionarios = new TelaFuncionarios();

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
		this.funcionarios.put(f);
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

		this.funcionarios.put(novoFuncionario);
	}

	public void excluiFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			if(funcionario.getChave() == null){
				System.out.println("Funcionario com chave não pode ser excluido");
				return;
			}
			this.funcionarios.remove(funcionario);
		}
	}

	public Funcionario getFuncionario(Integer numeroMatricula) {
		for (Funcionario funcionario : this.funcionarios.getList()) {
			if (funcionario.getNumeroMatricula() == numeroMatricula) {
				return funcionario;
			}
		}
		return null;
	}

	public boolean haFuncionarios() {
		if (this.funcionarios.isEmpty()) {
//			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return false;
		}
		return true;
	}

	public void exibeFuncionariosCadastrados() {
		if (this.funcionarios.isEmpty()) {
//			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return;
		}
		for (Funcionario funcionario : this.funcionarios.getList()) {
//			this.telaFuncionario.exibeFuncionario(funcionario);
		}
	}

	public void exibeTelaFuncionario() {
		this.telaFuncionarios.setVisible(true);
	}

	public void verificaMatricula(int matricula) throws CadastroIncorretoException {
		for (Funcionario funcionario : this.funcionarios.getList()) {
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

    public void voltarMenuPrincipal() {

    }
}
