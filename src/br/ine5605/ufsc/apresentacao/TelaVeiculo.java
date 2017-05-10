package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;
import br.ine5605.ufsc.controladores.ControladorVeiculos;

public class TelaVeiculo {
	private int opcao;
	private Scanner sc;
	private ControladorVeiculos owner;
	
	public TelaVeiculo(ControladorVeiculos owner){
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}
	
	public void exibeTelaVeiculo() {
		System.out.println("\n Bem Vindo a Tela de Veículos");
		System.out.println("Digite 1 para cadastrar Veículo");
		System.out.println("Digite 2 para alterar Veículo");
		System.out.println("Digite 3 para excluir Veículo");
		System.out.println("Digite 4 para listar Veiculos");
		System.out.println("Digite 0 Para retornar para o Menu Principal");
		this.opcao = sc.nextInt();
		tratadorOpcao();
	}
	
	public void tratadorOpcao(){
		switch (this.opcao) {
		case 1:
			exibeTelaCadastro();
			break;
		case 2:
			exibeTelaAltera();
		case 3:
			exibeTelaExclusao();
		case 4:
			
		case 0:
			//exibeMenuPrincipal();
		default:
			break;
		}
	}

	private void exibeTelaExclusao() {
		// TODO Auto-generated method stub
		
	}

	private void exibeTelaAltera() {
		// TODO Auto-generated method stub
		
	}

	private void exibeTelaCadastro() {
		System.out.println("\nBem vindo a tela de cadastro de funcionario");      
        sc.nextLine();
        
        System.out.println("\nInsira o Tipo do Veículo");
        System.out.println("1. Moto");
        System.out.println("2. Carro");
        System.out.println("3. Caminhonete");
        int tipo = sc.nextInt();
        
        System.out.println("\nInsira a Placa do Veículo");
        int placa = sc.nextInt();
        
        System.out.println("\nInsira o Modelo do Veículo");
        String modelo = sc.next();
        
        System.out.println("\nInsira a Marca do Veículo");
        String marca = sc.next();
        
        System.out.println("\nInsira o ano do Veiculo");
        int ano = sc.nextInt();
        
        System.out.println("\nInsira a Kilometragem do Veículo");
        int km = sc.nextInt();
        
        owner.cadastraVeiculo(placa, modelo, marca, ano, km, tipo);
		
	}
}