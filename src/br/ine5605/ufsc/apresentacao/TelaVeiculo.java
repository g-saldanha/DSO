package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorVeiculos;
import br.ufsc.ine5605.entidades.Veiculo;

public class TelaVeiculo {
	private int opcao;
	private Scanner sc;
	private ControladorVeiculos owner;
	
	public TelaVeiculo(ControladorVeiculos owner){
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}
	
	public void exibeTelaVeiculo() {
		do{
			System.out.println("\n Bem Vindo a Tela de Veículos");
			System.out.println("Digite 1 para cadastrar Veículo");
			System.out.println("Digite 2 para alterar Veículo");
			System.out.println("Digite 3 para excluir Veículo");
			System.out.println("Digite 4 para listar Veiculos");
			System.out.println("Digite 0 Para retornar para o Menu Principal");
			this.opcao = sc.nextInt();
			tratadorOpcao();
		}while(this.opcao != 0);
	}
	
	public void tratadorOpcao(){
		switch (this.opcao) {
		case 1:
			exibeTelaCadastro();
			break;
		case 2:
			exibeTelaAltera();
			break;
		case 3:
			exibeTelaExclusao();
			break;
		case 4:
			System.out.println("Lista de Veículos");
			System.out.println("-----------------");
			owner.exibirVeiculos();
		default:
			break;
		}
	}

	private void exibeTelaExclusao() {
		System.out.println("Digite a Placa do Veículo a ser excluído");
		String placa = sc.next();
		
		System.out.println("Tem certeza que deseja excluir o veículo");
		System.out.println("1. Sim       2. Não");
		int escolha = sc.nextInt();
		
		if(escolha == 1){
			owner.removeVeiculo(placa);
		}
	}

	private void exibeTelaAltera() {
		System.out.println("Digite a Placa do veículo a ser alterado");
		Veiculo veiculo = owner.pegaVeiculo(sc.next());
		
		System.out.println("Alterar Tipo");
		System.out.println("Tipo Atual: " + veiculo.getTipo());
		int tipo = sc.nextInt();
		veiculo.setTipo(tipo);
		
		System.out.println("Alterar Modelo");
		System.out.println("Modelo Atual: " + veiculo.getModelo());
		String modelo = sc.next();
		veiculo.setModelo(modelo);
		
		System.out.println("Alterar Marca");
		System.out.println("Marca Atual: " + veiculo.getMarca());
		String marca = sc.next();
		veiculo.setMarca(marca);
		
		System.out.println("Alterar Ano");
		System.out.println("Ano Atual: " + veiculo.getAno());
		int ano = sc.nextInt();
		veiculo.setAno(ano);
		
		System.out.println("Alterar Kilometragem");
		System.out.println("Kilometragem Atual: " + veiculo.getKm());
		int km = sc.nextInt();
		veiculo.setKm(km);
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
        String placa = sc.next();
        
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
	
	public void exibeVeiculos(Veiculo veiculo){
		System.out.println("Placa: " + veiculo.getPlaca() + "\nModelo: " + veiculo.getModelo() + "\nMarca: " + veiculo.getMarca() + "\nAno: " + veiculo.getAno() + 
				"\nTipo: " + (veiculo.getTipo() == 1 ? "Moto" : (veiculo.getTipo() == 2) ? "Carro" : "Caminhonete"));
		System.out.println("-----------------");
	}
}