package br.ufsc.ine5605.grupo3;

import br.ufsc.ine5605.grupo3.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.apresentacaoJframe.TelaCadastroFuncionarios;
import br.ufsc.ine5605.grupo3.apresentacaoJframe.TelaFuncionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Caio
 */
public class CtrlFunc implements java.io.Serializable{
	
	private final ControladorPrincipal owner;
	private TelaFuncionario telaFuncionario;
	private TelaCadastroFuncionarios telaCadastroFuncionarios;
	private FuncionarioDAO funcionarios;
	private static CtrlFunc instance;
	
	private CtrlFunc() {
		this.funcionarios = new FuncionarioDAO();
		this.telaFuncionario = new TelaFuncionario();
		this.owner = ControladorPrincipal.getInstance();
	}
	
	public static CtrlFunc getInstance() {
		if (instance == null) {
			instance = new CtrlFunc();
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
	
	public void cadastraFuncionario2(Integer numeroMatricula, String nome, Cargo cargo) {
		try {
			this.verificaMatricula(numeroMatricula);
		} catch (CadastroIncorretoException e) {
			System.out.println("Funcionario Existente");
			return;
		}
		
		Funcionario novoFuncionario = new Funcionario(numeroMatricula, nome, cargo);
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

/*	public boolean haFuncionarios() {
		if (this.funcionarios.isEmpty()) {
			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return false;
		}
		return true;
	}

  /*	public void exibeFuncionariosCadastrados() {
		if (this.funcionarios.isEmpty()) {
			this.telaFuncionario.mensagemNaoHaFuncionarios();
			return;
		}
		for (Funcionario funcionario : this.funcionarios.getList()) {
			this.telaFuncionario.exibeFuncionario(funcionario);
		}
	}

*/
	
	public void verificaMatricula(Integer matricula) throws CadastroIncorretoException {
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
	
	public void exibeTelaFuncionario() {
		this.telaFuncionario = new TelaFuncionario();
		telaFuncionario.setVisible(true);
	}
	
	public void exibeTelaCadastroFuncionarios() {
		this.telaCadastroFuncionarios = new TelaCadastroFuncionarios();
		telaCadastroFuncionarios.setVisible(true);
	}
	
	public void alteraFuncionario(Funcionario funcionario) {
		this.funcionarios.altera(funcionario);
	}
	
	public HashMap<Integer, Funcionario> getFuncionarios() {
		return this.funcionarios.getFuncionarios();
	}
	
	public void voltar() {
		this.telaFuncionario.setVisible(false);
		owner.exibeTelaInicial();
	}
	
	public void exibeTelaCadastroFuncionario() {
		this.telaCadastroFuncionarios = new TelaCadastroFuncionarios();
		telaCadastroFuncionarios.setVisible(true);
	}
	
	
	
	
	
	
	
}
