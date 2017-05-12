package br.ine5605.ufsc.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorChave;
import br.ufsc.ine5605.entidades.Chave;
import br.ufsc.ine5605.entidades.Funcionario;

public class TelaChave {
	private int opcao;
	private Scanner sc;
	private ControladorChave owner;
	
	public TelaChave(ControladorChave owner){
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}
	
	public void exibeTelaChave() {
		do{
			cls();
			System.out.println("\n Bem Vindo ao Claviculário");
			System.out.println("Digite 1 para Exibir Chaves");
			System.out.println("Digite 2 para Pegar Chave");
			System.out.println("Digite 3 para Devolver Chave");
			System.out.println("Digite 0 Para retornar para o Menu Principal");
			this.opcao = sc.nextInt();
			tratadorOpcao();
		}while(this.opcao != 0);
	}
	
	public void tratadorOpcao(){
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

	public void exibeTelaExibicao(Chave Chave, int index){
		System.out.println("Chave nº " + index + "\nPlaca: " + Chave.getPlaca() + "\nSituação: " + (Chave.isAlugada() ? "Alugada" : "Disponível"));
		System.out.println("-----------------");
	}

	private void exibeTelaPegar() {
		int tentativas = 0;
		Funcionario f = null;
		cls();
		
		while(tentativas < 3){
			System.out.println("Digite a sua matrícula");
			int matricula = sc.nextInt();
			f = owner.pegaFuncionario(matricula);
			
			if(f == null){
				System.out.println("Funcionário não encontrado");
			} else {
				break;
			}
		}
		
		tentativas = 0;
		do{
			System.out.println("Digite a chave desejada");
			String chave = sc.next();
			Chave c = owner.getChave(chave);
			if(c == null){
				System.out.println("Chave não encontrada");
			}  else {
				int result = owner.cederChave(f, c);
				if(result == 0){
					break;
				} else
				if(result == -1){
					System.out.println("Usuario nao possui acesso a chave");
				} else {
					System.out.println("Usuario já possui chave");
				}
				
			}
			tentativas++;
		} while (tentativas < 3);
		
		if(tentativas >= 3){
			System.out.println("Usuario Bloqueado");
		}
		
		
	}

	private void exibeTelaDevolver() {
		cls();
		System.out.println("\nBem vindo a tela de cadastro de funcionario");
		System.out.println("Digite a sua matrícula");
		int matricula = sc.nextInt();
		
		System.out.println("Digite a chave desejada");
		int chave = sc.nextInt();
		
		System.out.println("Digite a Kilometragem atual do veículo");
		int km = sc.nextInt();
        
	}

	public static void cls(){
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
}