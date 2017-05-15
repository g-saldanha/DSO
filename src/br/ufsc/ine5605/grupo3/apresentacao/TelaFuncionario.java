package br.ufsc.ine5605.grupo3.apresentacao;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufsc.ine5605.grupo3.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio
 */
public class TelaFuncionario implements Tela {

	private ControladorFuncionario owner;
	private Scanner sc;

	public TelaFuncionario(ControladorFuncionario owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}

	@Override
	public void exibirTela() {
		int opcao = 0;
		do {
			System.out.println("\nBem vindo a tela do funcionario");
			System.out.println("Digite 1 para cadastrar funcionario");
			System.out.println("Digite 2 para alterar funcionario");
			System.out.println("Digite 3 para excluir funcionario");
			System.out.println("Digite 4 para listar funcionarios cadastrados");
			System.out.println("Digite 5 para desbloquear funcionarios");
			System.out.println("Digite 0 para retornar ao menu principal");
			opcao = this.sc.nextInt();
			try {
				this.trataOpcao(opcao);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (opcao != 0);
	}

	public void trataOpcao(int opcao) throws CadastroIncorretoException {
		switch (opcao) {
		case 1:
			this.telaCadastroFuncionario();
			break;
		case 2:
			this.telaAlteraFuncionario(); // fazer
			break;
		case 3:
			this.telaRemoveFuncionario();
			break;
		case 4:
			this.owner.exibeFuncionariosCadastrados();
			break;
		case 5:
			this.telaDesbloqueio();
		}
	}

	public void telaDesbloqueio() {
		System.out.println("Digite a matricula de um diretor");
		int mat1 = this.sc.nextInt();
		Funcionario dir = this.owner.getFuncionario(mat1);
		if (dir == null) {
			System.out.println("Funcionario inexistente");
			return;
		}
		if (dir.getCargo() != Cargo.DIRETORIA) {
			System.out.println("Nao é diretor");
			return;
		}
		System.out.println("Digite a matricula do funcionario bloqueado");
		int mat2 = this.sc.nextInt();
		Funcionario blok = this.owner.getFuncionario(mat2);
		if (blok == null) {
			System.out.println("Funcionario inexistente");
			return;
		}
		if (!blok.getBloqueado()) {
			System.out.println("Nao esta bloqueado");
			return;
		}
		this.owner.desbloqueia(blok);

	}

	public void telaCadastroFuncionario() throws CadastroIncorretoException {
		try {

			ArrayList<Veiculo> tiposDeVeiculo = new ArrayList<>();
			System.out.println("\nBem vindo a tela de cadastro de funcionario");
			System.out.println("\nInsira o nome do funcionario");
			String nome = this.sc.next();

			System.out.println("\nInsira o numero de matricula do funcionario");
			int matricula = this.sc.nextInt();

			System.out.println("\nInsira a data de nascimento do funcionario");
			int dataNascimento = this.sc.nextInt();

			System.out.println("\nInsira o telefone do funcionario");
			int telefone = this.sc.nextInt();

			System.out.println("\nInsira o cargo do funcionario");
			System.out.println("0.Comum");
			System.out.println("1.Diretoria");

			int selecaoCargo = this.sc.nextInt();
			Cargo cargo = Cargo.COMUM;
			while (selecaoCargo != 0) {
				if (selecaoCargo == 1) {
					cargo = Cargo.DIRETORIA;
					break;
				}
				selecaoCargo = this.sc.nextInt();

			}
			String opt = "";

			while (!opt.equals("N") && cargo != Cargo.DIRETORIA) {
				System.out.println("Quer adicionar um veículo que o funcionário pode usar?");
				System.out.println("Digite 'S' para Sim");
				System.out.println("Digite 'N' para Não");
				opt = this.sc.next();
				if (opt.equals("N")) {
					break;
				}
				System.out.println("Digite a placa do veículo que o funcionário terá acesso");
				opt = this.sc.next();
				Veiculo v = this.owner.pegaVeiculo(opt);
				if (v != null) {
					tiposDeVeiculo.add(v);
				} else {
					System.out.println("Veículo Inexistente");
				}
			}

			this.owner.cadastraFuncionario(matricula, nome, dataNascimento, telefone, cargo, tiposDeVeiculo);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
	}

	public void telaAlteraFuncionario() {
		try {
			if (this.owner.haFuncionarios() == false) {
				return;
			}

			System.out.println("Digite a Matricula do funcionario a ser alterado");
			Funcionario f = this.owner.getFuncionario(this.sc.nextInt());
			if (f == null) {
				System.out.println("Funcionario nao encontrado");
				return;
			}

			System.out.println("Alterar Nome");
			System.out.println("Nome Atual: " + f.getNome());
			String nome = this.sc.next();
			f.setNome(nome);

			System.out.println("Alterar Telefone");
			System.out.println("Telefone Atual: " + f.getTelefone());
			int tel = this.sc.nextInt();
			f.setTelefone(tel);

			System.out.println("Alterar Data de Nascimento");
			System.out.println("Data Atual: " + f.getDataNascimento());
			int data = this.sc.nextInt();
			f.setDataNascimento(data);

			System.out.println("Alterar Cargo");
			System.out.println("0.Comum");
			System.out.println("1.Diretoria");
			System.out.println("Cargo Atual: " + f.getCargo());
			Cargo ano = this.sc.nextInt() == 0 ? Cargo.COMUM : Cargo.DIRETORIA;
			f.setCargo(ano);

			String opt = "";
			ArrayList<Veiculo> tiposDeVeiculo = new ArrayList<Veiculo>();
			while (!opt.equals("N") && f.getCargo() != Cargo.DIRETORIA) {
				System.out.println("Alterar Veiculos");

				System.out.println("Quer adicionar um veículo que o funcionário pode usar?");
				System.out.println("Digite 'S' para Sim");
				System.out.println("Digite 'N' para Não");
				opt = this.sc.next();
				if (opt.equals("N")) {
					break;
				}
				System.out.println("Digite a placa do veículo que o funcionário terá acesso");
				opt = this.sc.next();
				Veiculo v = this.owner.pegaVeiculo(opt);
				if (v != null) {
					tiposDeVeiculo.add(v);
				} else {
					System.out.println("Veículo Inexistente");
				}
			}
			f.setTiposDeVeiculo(tiposDeVeiculo);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}

	}

	public void telaRemoveFuncionario() {
		try {
			if (!this.owner.haFuncionarios()) {
				return;
			}
			System.out.println("\nBem vindo a tela de remocao de funcionario");
			System.out.println("\nInsira a matricula do funcionario a ser removido");
			int matricula = this.sc.nextInt();
			Funcionario funcionarioARemover = this.owner.getFuncionario(matricula);
			if (funcionarioARemover != null) {
				if (funcionarioARemover.getChave() == null) {
					this.owner.excluiFuncionario(funcionarioARemover);
				} else {
					System.out.println("Funcionario nao pode ser excluido pois possui uma chave");
				}
			} else {
				System.out.println("Erro ao excluir funcionario");
			}
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}

	}

	public void mensagemNaoHaFuncionarios() {
		System.out.println("Nao ha funcionarios cadastrados\n");
	}

	public void exibeFuncionario(Funcionario funcionario) {
		System.out.println("-----------------------------");
		System.out.println("Nome do funcionario: " + funcionario.getNome() + " \nNumero de matricula: " + funcionario.getNumeroMatricula() + "\nCargo: " + funcionario.getCargo());
	}

}
