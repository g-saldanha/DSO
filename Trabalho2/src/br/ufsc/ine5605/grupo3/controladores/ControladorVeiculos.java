package br.ufsc.ine5605.grupo3.controladores;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaCadastroVeiculo;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaVeiculos;
import br.ufsc.ine5605.grupo3.entidades.*;

import java.util.ArrayList;

public class ControladorVeiculos {
	private static ControladorVeiculos instance;
	private VeiculosDAO veiculos;
	private TelaVeiculos telaVeiculos;
	private TelaCadastroVeiculo telaCadastroVeiculo;

	public ControladorVeiculos() {
		this.telaVeiculos = new TelaVeiculos();
		this.telaCadastroVeiculo = new TelaCadastroVeiculo();
		this.veiculos = new VeiculosDAO();

	}

	public static ControladorVeiculos getInstance() {
		if (instance == null) {
			instance = new ControladorVeiculos();
		}

		return instance;
	}

	public void cadastrarVeiculo(Veiculo v) {
		if (!this.checkExists(v.getPlaca())) {
			this.veiculos.put(v);
		} else {
			System.out.println("Veiculo de mesma placa já existe");
		}
	}

	public void cadastraVeiculo(String placa, String modelo, String marca, Integer ano, Integer km, Tipo tipo) {
		if (!this.checkExists(placa)) {
			Veiculo novo = null;
			if (tipo.equals(Tipo.MOTO)) {
				novo = new Moto(placa, modelo, marca, ano, km);
			} else if (tipo.equals(Tipo.CARRO)) {
				novo = new Carro(placa, modelo, marca, ano, km);
			} else if (tipo.equals(Tipo.CAMINHONETE)) {
				novo = new Caminhonete(placa, modelo, marca, ano, km);
			}
			this.veiculos.put(novo);
//			ControladorPrincipal.getInstance().adicionarChave(placa);
		} else {
			System.out.println("Veiculo de mesma placa já existe");
		}
	}

	public void removeVeiculo(String placa) {
		if (this.checkExists(placa)) {
			Veiculo v = this.pegaVeiculo(placa);
			if (ControladorPrincipal.getInstance().pegaChave(placa).isAlugada()) {
				System.out.println("Veiculo Alugado Não Pode Ser Excluido");
				return;
			}
			this.veiculos.remove(v);
			ControladorPrincipal.getInstance().deletarChave(placa);
		}
	}

	public Veiculo pegaVeiculo(String placa) {
		for (Veiculo v : this.veiculos.getVeiculos()) {
			if (this.checkExists(placa)) {
				return v;
			}
		}
		return null;
	}

	public boolean checkExists(String placa) {
		for (Veiculo v : this.veiculos.getVeiculos()) {
			if (v.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;
	}

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos.getVeiculos();
    }

    public void voltarMenuPrincipal() {
	    ControladorPrincipal.getInstance().voltarMenuPrincipal();
    }

    public void exibeTelaVeiculos() {
		telaVeiculos.atualizaLista();
	    telaVeiculos.setVisible(true);
    }

    public void exibeTelaCadastroVeiculo(){
		telaCadastroVeiculo.setVisible(true);
	}
}
