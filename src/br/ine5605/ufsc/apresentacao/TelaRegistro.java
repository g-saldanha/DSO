package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorRegistro;
import br.ufsc.ine5605.entidades.Registro;

public class TelaRegistro implements Tela{
	private ControladorRegistro owner;
	private Scanner sc;

	public TelaRegistro(ControladorRegistro owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}

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
			opcao = sc.nextInt();
			trataOpcao(opcao);
		} while (opcao != 0);
	}

	public void trataOpcao(int opcao) {
		switch (opcao) {
		case 1:
			owner.exibeTelaRegistro();
			break;
		case 2:
			exibTelaRegistrosPorMatricula();
			break;
		case 3:
			exibTelaRegistrosPorPlaca();
			break;
		case 4:
			exibTelaRegistrosPorMotivo();
		default:
			break;
		}
	}

	private void exibTelaRegistrosPorMatricula() {
		System.out.println("Digite o numero da Matricula Desejada");
		System.out.println("-------------------------------------");
		int matricula = sc.nextInt();

		owner.exibTelaRegistrosPorFiltro(matricula);
	}

	private void exibTelaRegistrosPorPlaca() {
		System.out.println("Digite a Placa Desejada");
		System.out.println("-------------------------------------");
		String placa = sc.next();

		owner.exibTelaRegistrosPorFiltro(placa);
	}

	private void exibTelaRegistrosPorMotivo() {
		System.out.println("Digite o motivo Desejada");
		System.out.println("0. Permissão");
		System.out.println("1. Negação");
		System.out.println("-------------------------------------");
		int motivo = sc.nextInt();
		boolean m = false;
		if (motivo == 0) {
			m = true;
		}

		owner.exibTelaRegistrosPorFiltro(m);
	}

	public void exibeRegistros(Registro r) {
		System.out.println("Data: " + r.getData() + "/" + r.getMes() + "\nHora: " + r.getHora() + "\nMatricula: "
				+ (r.getFuncionario() != null ? (r.getFuncionario().getNumeroMatricula() + "\nNome: " + r.getFuncionario().getNome()) : "")
				+ (r.getVeiculo() != null ? ("\nPlaca: " + r.getVeiculo().getPlaca()) : "")
				+ (r.getMotivo() ? "\nACESSO PERMITIDO: " : "\nACESSO NEGADO: ") + r.getMensagem());
		System.out.println("------------------------------------------------");
	}

}
