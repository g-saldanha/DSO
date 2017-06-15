package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Caminhonete;
import br.ufsc.ine5605.grupo3.entidades.Carro;
import br.ufsc.ine5605.grupo3.entidades.Moto;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class ControladorVeiculos {
	private static ControladorVeiculos instance;
	private ArrayList<Veiculo> veiculos;
	private TelaVeiculos telaVeiculos;

	public ControladorVeiculos() {
		this.telaVeiculos = new TelaVeiculos();
	}

	public static ControladorVeiculos getInstance() {
		if (instance == null) {
			instance = new ControladorVeiculos();
		}

		return instance;
	}

	public void cadastrarVeiculo(Veiculo v) {
		if (!this.checkExists(v.getPlaca())) {
			this.veiculos.add(v);
		} else {
			System.out.println("Veiculo de mesma placa já existe");
		}
	}

	public void cadastraVeiculo(String placa, String modelo, String marca, Integer ano, Integer km, Integer tipo) {
		if (!this.checkExists(placa)) {
			Veiculo novo = null;
			if (tipo == 1) {
				novo = new Moto(placa, modelo, marca, ano, km);
			} else if (tipo == 2) {
				novo = new Carro(placa, modelo, marca, ano, km);
			} else if (tipo == 3) {
				novo = new Caminhonete(placa, modelo, marca, ano, km);
			}
			this.veiculos.add(novo);
			ControladorPrincipal.getInstance().adicionarChave(placa);
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
		for (Veiculo v : this.veiculos) {
			if (this.checkExists(placa)) {
				return v;
			}
		}
		return null;
	}

	public boolean checkExists(String placa) {
		for (Veiculo v : this.veiculos) {
			if (v.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;
	}

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void voltarMenuPrincipal() {
	    ControladorPrincipal.getInstance().voltarMenuPrincipal();
    }

    public void exibeTelaVeiculos() {
	    telaVeiculos.setVisible(true);
    }
}
