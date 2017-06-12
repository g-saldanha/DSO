package br.ufsc.ine5605.grupo3.apresentacao;

import java.util.Scanner;

import br.ufsc.ine5605.grupo3.controladores.ControladorRegistro;
import br.ufsc.ine5605.grupo3.entidades.Registro;

public class TelaRegistro implements Tela {
	private ControladorRegistro owner;
	private Scanner sc;

	public TelaRegistro(ControladorRegistro owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}

	@Override
	public void exibirTela() {
		// pesquisar/filtrar por: motivo de negação/permissão, pela
		// matrícula do funcionário ou pela placa do veículo.
		int opcao = 0;
		do {
			System.out.println("Bem vindo a Tela de Registros");
			System.out.println("-----------------------------");
			System.out.println("Digite 1 para ver todos os registros");
			System.out.println("Digite 2 para procurar o resgistros por matricula");
			System.out.println("Digite 3 para procurar o resgistros por placa");
			System.out.println("Digite 4 para procurar o resgistros por motivo");
			System.out.println("Digite 0 para voltar");
			opcao = this.sc.nextInt();
			this.trataOpcao(opcao);
		} while (opcao != 0);
	}

	public void trataOpcao(int opcao) {
		switch (opcao) {
		case 1:
			this.owner.exibeTelaRegistro();
			break;
		case 2:
			this.exibTelaRegistrosPorMatricula();
			break;
		case 3:
			this.exibTelaRegistrosPorPlaca();
			break;
		case 4:
			this.exibTelaRegistrosPorMotivo();
		default:
			break;
		}
	}

	private void exibTelaRegistrosPorMatricula() {
		try {
			System.out.println("Digite o numero da Matricula Desejada");
			System.out.println("-------------------------------------");
			int matricula = this.sc.nextInt();

			this.owner.exibTelaRegistrosPorFiltro(matricula);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
	}

	private void exibTelaRegistrosPorPlaca() {
		System.out.println("Digite a Placa Desejada");
		System.out.println("-------------------------------------");
		String placa = this.sc.next();

		this.owner.exibTelaRegistrosPorFiltro(placa);
	}

	private void exibTelaRegistrosPorMotivo() {
		try {
			System.out.println("Digite o motivo Desejada");
			System.out.println("0. Permissão");
			System.out.println("1. Negação");
			System.out.println("-------------------------------------");
			int motivo = this.sc.nextInt();
			boolean m = false;
			if (motivo == 0) {
				m = true;
			}

			this.owner.exibTelaRegistrosPorFiltro(m);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
	}

	public void exibeRegistros(Registro r) {
		System.out.println("Data: " + r.getData() + "/" + r.getMes() + "\nHora: " + r.getHora() + "\nMatricula: "
				+ (r.getFuncionario() != null ? r.getFuncionario().getNumeroMatricula() + "\nNome: " + r.getFuncionario().getNome() : "")
				+ (r.getVeiculo() != null ? "\nPlaca: " + r.getVeiculo().getPlaca() : "") + (r.getMotivo() ? "\nACESSO PERMITIDO: " : "\nACESSO NEGADO: ") + r.getMensagem());
		System.out.println("------------------------------------------------");
	}

}
