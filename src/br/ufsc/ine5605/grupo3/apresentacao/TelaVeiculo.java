package br.ufsc.ine5605.grupo3.apresentacao;

import java.util.Scanner;

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class TelaVeiculo implements Tela{
	private int opcao;
	private Scanner sc;
	private ControladorVeiculos owner;

	public TelaVeiculo(ControladorVeiculos owner) {
		this.owner = owner;
		this.sc = new Scanner(System.in);
	}

	@Override
	public void exibirTela() {
		do {
			System.out.println("\n Bem Vindo a Tela de Veículos");
			System.out.println("Digite 1 para cadastrar Veículo");
			System.out.println("Digite 2 para alterar Veículo");
			System.out.println("Digite 3 para excluir Veículo");
			System.out.println("Digite 4 para listar Veiculos");
			System.out.println("Digite 0 Para retornar para o Menu Principal");
			this.opcao = this.sc.nextInt();
			this.tratadorOpcao();
		} while (this.opcao != 0);
	}

	public void tratadorOpcao() {
		switch (this.opcao) {
		case 1:
			this.exibeTelaCadastro();
			break;
		case 2:
			this.exibeTelaAltera();
			break;
		case 3:
			this.exibeTelaExclusao();
			break;
		case 4:
			System.out.println("Lista de Veículos");
			System.out.println("-----------------");
			this.owner.exibirVeiculos();
		default:
			break;
		}
	}

	private void exibeTelaExclusao() {
		try {
			System.out.println("Digite a Placa do Veículo a ser excluído");
			String placa = this.sc.next();

			System.out.println("Tem certeza que deseja excluir o veículo");
			System.out.println("1. Sim       2. Não");
			int escolha = this.sc.nextInt();

			if (escolha == 1) {
				this.owner.removeVeiculo(placa);
			}
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
	}

	private void exibeTelaAltera() {
		try {
			System.out.println("Digite a Placa do veículo a ser alterado");
			Veiculo veiculo = this.owner.pegaVeiculo(this.sc.next());
			if(veiculo == null){
				System.out.println("Veiculo não encontrado");
				return;
			}

			System.out.println("Alterar Tipo");
			System.out.println("Tipo Atual: " + veiculo.getTipo());
			int tipo = this.sc.nextInt();
			veiculo.setTipo(tipo);

			System.out.println("Alterar Modelo");
			System.out.println("Modelo Atual: " + veiculo.getModelo());
			String modelo = this.sc.next();
			veiculo.setModelo(modelo);

			System.out.println("Alterar Marca");
			System.out.println("Marca Atual: " + veiculo.getMarca());
			String marca = this.sc.next();
			veiculo.setMarca(marca);

			System.out.println("Alterar Ano");
			System.out.println("Ano Atual: " + veiculo.getAno());
			int ano = this.sc.nextInt();
			veiculo.setAno(ano);

			System.out.println("Alterar Kilometragem");
			System.out.println("Kilometragem Atual: " + veiculo.getKm());
			int km = this.sc.nextInt();
			veiculo.setKm(km);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
	}

	private void exibeTelaCadastro() {
		try {
			System.out.println("\nBem vindo a tela de cadastro de funcionario");
			this.sc.nextLine();

			System.out.println("\nInsira o Tipo do Veículo");
			System.out.println("1. Moto");
			System.out.println("2. Carro");
			System.out.println("3. Caminhonete");
			int tipo = this.sc.nextInt();

			System.out.println("\nInsira a Placa do Veículo");
			String placa = this.sc.next();

			System.out.println("\nInsira o Modelo do Veículo");
			String modelo = this.sc.next();

			System.out.println("\nInsira a Marca do Veículo");
			String marca = this.sc.next();

			System.out.println("\nInsira o ano do Veiculo");
			int ano = this.sc.nextInt();

			System.out.println("\nInsira a Kilometragem do Veículo");
			int km = this.sc.nextInt();

			this.owner.cadastraVeiculo(placa, modelo, marca, ano, km, tipo);
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}

	}

	public void exibeVeiculos(Veiculo veiculo) {
		System.out.println("Placa: " + veiculo.getPlaca() + "\nModelo: " + veiculo.getModelo() + "\nMarca: "
				+ veiculo.getMarca() + "\nAno: " + veiculo.getAno() + "\nTipo: "
				+ (veiculo.getTipo() == 1 ? "Moto" : veiculo.getTipo() == 2 ? "Carro" : "Caminhonete"));
		System.out.println("-----------------");
	}
}