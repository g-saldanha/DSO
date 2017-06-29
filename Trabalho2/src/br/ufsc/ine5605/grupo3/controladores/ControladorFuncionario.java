/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaCadastroFuncionarios;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaFuncionarios;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaPermissaoVeiculos;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio & Gabriel
 */
public class ControladorFuncionario {

	private TelaFuncionarios telaFuncionarios;
	private FuncionarioDAO funcionarios;
	private static ControladorFuncionario instance;
	private TelaCadastroFuncionarios telaCadastroFuncionarios;
	private TelaPermissaoVeiculos telaPermissoes;

	private ControladorFuncionario() {
		this.telaFuncionarios = new TelaFuncionarios();
		this.funcionarios = new FuncionarioDAO();

	}

	public static ControladorFuncionario getInstance() {
		if (instance == null) {
			instance = new ControladorFuncionario();
		}

		return instance;
	}

	public void cadastraFuncionario(Funcionario f){
		try {
			verificaMatricula(f.getNumeroMatricula());
		} catch (CadastroIncorretoException e) {
			System.out.println("Funcionario Existente");
			return;
		}
		this.funcionarios.put(f);
	}

	public String cadastraFuncionario(Integer numeroMatricula, String nome, Integer dataNascimento, Integer telefone, Cargo cargo) {
		try {
			verificaMatricula(numeroMatricula);
		} catch (CadastroIncorretoException e) {
			return "Funcionario Existente";
		}

		Funcionario novoFuncionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo);

		this.funcionarios.put(novoFuncionario);
		return "Funcionario" + nome + "Cadastrado com Sucesso";
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

	public Funcionario getFuncionario(Integer numeroMatricula) throws CadastroIncorretoException, IOException {
		for (Funcionario funcionario : this.funcionarios.getFuncionarios()) {
			if (funcionario.getNumeroMatricula().equals(numeroMatricula)) {
				return funcionario;
			}
		}
		return null;
	}
// MensagemNãoHaFuncionario, qual a aplicação dela?:
	public boolean haFuncionarios() {
		if (this.funcionarios.isEmpty()) {
//			this.telaFuncionarios.mensagemNaoHaFuncionarios();
			return false;
		}
		return true;
	}

	public void exibeFuncionariosCadastrados() {
		if (this.funcionarios.isEmpty()) {
//			this.telaFuncionarios.mensagemNaoHaFuncionarios();
			return;
		}
//		Aonde é criado esse método?
		for (Funcionario funcionario : this.funcionarios.getList()) {
//			this.telaFuncionarios.exibeFuncionario(funcionario);
		}
	}

	public void exibeTelaFuncionario() {
		this.telaFuncionarios.setVisible(true);
		this.telaFuncionarios.atualizaLista();
	}

	public void verificaMatricula(int matricula) throws CadastroIncorretoException {
		for (Funcionario funcionario : this.funcionarios.getList()) {
			if (funcionario.getNumeroMatricula() == matricula) {
				throw new CadastroIncorretoException("matricula existente!");
			}
		}
	}

	public Veiculo pegaVeiculo(String opt) throws IOException {
		return ControladorPrincipal.getInstance().pegaVeiculo(opt);
	}

	public static void bloquearFuncionario(Funcionario f) {
		f.bloquear();
	}

	public static void desbloqueia(Funcionario blok) {
		blok.desbloquear();
	}


//	Não entendi o por que dessa função aqui
	public ArrayList<Funcionario> getListaFuncionarios(){
		return this.funcionarios.getFuncionarios();
	}

    public void voltarMenuPrincipal() throws IOException {
		ControladorPrincipal.getInstance().voltarMenuPrincipal();
    }

    public void exibeTelaCadastroFuncionario(){
		this.telaFuncionarios.setVisible(false);
		this.telaCadastroFuncionarios = new TelaCadastroFuncionarios();
		this.telaCadastroFuncionarios.setVisible(true);
    }

	public void exibeTelaCadastroFuncionario(Funcionario f) {
		this.telaFuncionarios.setVisible(false);
		this.telaCadastroFuncionarios = new TelaCadastroFuncionarios(f);
		this.telaCadastroFuncionarios.setVisible(true);

	}

	public String alteraFuncionario(Integer matricula, String nome, Integer nascimento, Integer telefone, Cargo cargo) {
		for (Funcionario f : this.funcionarios.getFuncionarios()) {
			if (f.getNumeroMatricula().equals(matricula)) {
				f.setCargo(cargo);
				f.setDataNascimento(nascimento);
				f.setNome(nome);
				f.setTelefone(telefone);
				this.funcionarios.persist();
				return "Funcionario " + nome + " alterado com sucesso";
			}
		}
		return "Funcionario não existe ou não pode ser alterado";
	}

	public ArrayList<Integer> getMatriculas() {
		ArrayList<Integer> matriculas = new ArrayList<>();
		for (Funcionario f : this.funcionarios.getFuncionarios()) {
			matriculas.add(f.getNumeroMatricula());
		}
		return matriculas;
	}

	public void exibeTelaPermissões(Integer i, String string, Integer j, Integer k, Cargo cargo) {
		this.telaCadastroFuncionarios.setVisible(false);
		this.telaFuncionarios.setVisible(false);
		this.telaPermissoes = new TelaPermissaoVeiculos(i, string, j, k, cargo);
		this.telaPermissoes.setVisible(true);

	}

	public String cadastraFuncionario(Integer i, String string, Integer j, Integer k, Cargo cargo, ArrayList<Veiculo> veiculos) {
		try {
			verificaMatricula(i);
		} catch (CadastroIncorretoException e) {
			return "Funcionario Existente";
		}

		Funcionario novoFuncionario = new Funcionario(i, string, j, k, cargo, veiculos);

		this.funcionarios.put(novoFuncionario);
		return "Funcionario" + string + "Cadastrado com Sucesso";

	}

}
