package br.ine5605.ufsc.apresentacao;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorChave;
import br.ufsc.ine5605.entidades.Chave;
import br.ufsc.ine5605.entidades.Funcionario;

public class TelaChave implements Tela{
	private int opcao;
	private Scanner sc;
	private ControladorChave owner;

	public TelaChave(ControladorChave owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}

	public void exibirTela() {
		do {
			cls();
			System.out.println("\n Bem Vindo ao Claviculário");
			System.out.println("Digite 1 para Exibir Chaves");
			System.out.println("Digite 2 para Pegar Chave");
			System.out.println("Digite 3 para Devolver Chave");
			System.out.println("Digite 0 Para retornar para o Menu Principal");
			this.opcao = sc.nextInt();
			tratadorOpcao();
		} while (this.opcao != 0);
	}

	public void tratadorOpcao() {
		cls();
		switch (this.opcao) {
		case 1:
			System.out.println("Lista de Chaves");
			System.out.println("-----------------");
			owner.exibirChaves();
			break;
		case 2:
			exibeTelaPegar();
			break;
		case 3:
			exibeTelaDevolver();
			break;
		default:
			break;
		}
	}

	public void exibeTelaExibicao(Chave Chave, int index) {
		System.out.println("Chave nº " + index + "\nPlaca: " + Chave.getPlaca() + "\nSituação: "
				+ (Chave.isAlugada() ? "Alugada" : "Disponível"));
		System.out.println("-----------------");
	}

	private void exibeTelaPegar() {
		int tentativas = 0;
		Funcionario f = null;
		cls();

		while (tentativas < 3) {
			System.out.println("Digite a sua matrícula");
			int matricula = sc.nextInt();
			f = owner.pegaFuncionario(matricula);

			if (f == null) {
				System.out.println("Matricula não existe");
				owner.adicionarRegistro(Calendar.getInstance().getTime().getDate(),Calendar.getInstance().getTime().getMonth(),
						Calendar.getInstance().getTime().getHours(), f, null, false, "Matricula não existente");
			} else {
				break;
			}
			tentativas++;
		}

		if (tentativas >= 3) {
			System.out.println("Tentativas demais com matricula errada");
			return;
		}

		tentativas = 0;
		do {
			System.out.println("Digite a chave desejada");
			String chave = sc.next();
			Chave c = owner.getChave(chave);
			if (c == null) {
				System.out.println("Chave não encontrada");
				owner.adicionarRegistro(Calendar.getInstance().getTime().getDate(),
						Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						null, false, "Veiculo não existente");
			} else {
				int result = owner.cederChave(f, c);
				if (result == 0) {
					break;
				} else if (result == -1) {
					System.out.println("Usuario nao possui acesso a chave");
				} else if (result == -2) {
					System.out.println("Usuario já possui chave");
				} else {
					System.out.println("Usuario Bloqueado");
				}

			}
			tentativas++;
		} while (tentativas < 3);

		if (tentativas >= 3) {
			System.out.println("Usuario Bloqueado");
			owner.bloquearFuncionario(f);
		}

	}

	private void exibeTelaDevolver() {
		cls();
		int tentativas = 0;
		Funcionario f = null;

		while (tentativas < 3) {
			System.out.println("Digite a sua matrícula");
			int matricula = sc.nextInt();
			f = owner.pegaFuncionario(matricula);

			if (f == null) {
				System.out.println("Funcionário não encontrado");
				owner.adicionarRegistro(Calendar.getInstance().getTime().getDate(),Calendar.getInstance().getTime().getMonth(),
						Calendar.getInstance().getTime().getHours(), f, null, false,
						"Devolucao : Matricula não existente");
			} else {
				break;
			}
			tentativas++;
		}

		tentativas = 0;
		do {
			System.out.println("Digite a chave desejada");
			String chave = sc.next();
			Chave c = owner.getChave(chave);
			if (c == null) {
				System.out.println("Chave não encontrada");
				owner.adicionarRegistro(Calendar.getInstance().getTime().getDate(),Calendar.getInstance().getTime().getMonth(),
						Calendar.getInstance().getTime().getHours(), f, null, false, "Devolucao : Chave não existente");
			} else {
				int result = owner.devolverChave(f, c);
				if (result == 0) {
					break;
				} else if (result == -1) {
					System.out.println("Usuario nao possui chave");
				}
			}
			tentativas++;
		} while (tentativas < 3);

		if (tentativas >= 3) {
			System.out.println("Usuario Bloqueado");
			owner.bloquearFuncionario(f);
		}

	}

	public static void cls() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}