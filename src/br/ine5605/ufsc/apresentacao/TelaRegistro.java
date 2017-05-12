package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorRegistro;
import br.ufsc.ine5605.entidades.Registro;

public class TelaRegistro {
	private ControladorRegistro owner;
	private Scanner sc;
	
	public TelaRegistro(ControladorRegistro owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}
	
	public void exibeTelaRegistro(){
		//pesquisar/filtrar por: motivo de negação/permissão, pela matrícula do funcionário ou pela placa do veículo.
		System.out.println("Bem vindo a Tela de Registros");
		System.out.println("-----------------------------");
		System.out.println("Digite 1 para ver todos os registros");
		System.out.println("Digite 2 para procurar o resgistros por matricula");
		System.out.println("Digite 3 para procurar o resgistros por placa");
		System.out.println("Digite 4 para procurar o resgistros por motivo");
		int opcao = sc.nextInt();
		trataOpcao(opcao);
	}
	
	public void trataOpcao(int opcao){
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
		System.out.println("1. Permissão");
		System.out.println("2. Negação");
		System.out.println("-------------------------------------");
		boolean motivo = sc.hasNextBoolean();
		
		owner.exibTelaRegistrosPorFiltro(motivo);
	}

	public void exibeRegistros(Registro r) {
		String placa = r.getVeiculo().getPlaca();
		System.out.println("Data: " + r.getData() + "\nHora: " + r.getHora() + "\nMatricula: " + r.getMatricula() + 
				"\nNome: " + "nome" + "\nPlaca: " + placa + "\nMotivo: " + r.getMotivo());
		System.out.println("------------------------------------------------");
	}
	
	
	
	
}
