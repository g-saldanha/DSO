package br.ufsc.ine5605.grupo3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaCadastroVeiculo;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Caminhonete;
import br.ufsc.ine5605.grupo3.entidades.Carro;
import br.ufsc.ine5605.grupo3.entidades.Moto;
import br.ufsc.ine5605.grupo3.entidades.Tipo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

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

	public String cadastrarVeiculo(Veiculo v) {
		if (!checkExists(v.getPlaca())) {
			this.veiculos.put(v);
		} else {
			return "Veiculo de mesma placa já existe";
		}
		return "Veículo Placa " + v.getPlaca() + " Cadastrado com sucesso";
	}

	public String cadastraVeiculo(String placa, String modelo, String marca, Integer ano, Integer km, Tipo tipo) throws IOException {
		if (!checkExists(placa)) {
			Veiculo novo = null;
			if (tipo.equals(Tipo.MOTO)) {
				novo = new Moto(placa, modelo, marca, ano, km);
			} else if (tipo.equals(Tipo.CARRO)) {
				novo = new Carro(placa, modelo, marca, ano, km);
			} else if (tipo.equals(Tipo.CAMINHONETE)) {
				novo = new Caminhonete(placa, modelo, marca, ano, km);
			}
			this.veiculos.put(novo);

			ControladorPrincipal.getInstance().adicionarChave(placa);
			return "Veículo Placa " + placa + " Cadastrado com sucesso";
		} else {
			return "Veiculo de mesma placa já existe";
		}
	}

	public void removeVeiculo(String placa) {
		if (checkExists(placa)) {
			Veiculo v = pegaVeiculo(placa);
//			if (ControladorPrincipal.getInstance().pegaChave(placa).isAlugada()) {
//				System.out.println("Veiculo Alugado Não Pode Ser Excluido");
//				return;
//			}
			this.veiculos.remove(v);
//			ControladorPrincipal.getInstance().deletarChave(ControladorChave.getInstance().getChave(placa).getID());
		}
	}

	public Veiculo pegaVeiculo(String placa) {
		for (Veiculo v : this.veiculos.getVeiculos()) {
			if (v.getPlaca().equals(placa)) {
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
        return this.veiculos.getVeiculos();
    }

    public void voltarMenuPrincipal() throws IOException {
	    ControladorPrincipal.getInstance().voltarMenuPrincipal();
    }

    public void exibeTelaVeiculos() {
		this.telaVeiculos.atualizaLista();
	    this.telaVeiculos.setVisible(true);
    }

    public void exibeTelaCadastroVeiculo(){
		this.telaCadastroVeiculo.setVisible(true);
	}

	public void exibeTelaEditaVeiculo(String placa) {
		this.telaCadastroVeiculo = new TelaCadastroVeiculo(placa);
		this.telaCadastroVeiculo.setVisible(true);

	}

	public ArrayList<String> getPlacas() {
		ArrayList<String> placas = new ArrayList<>();
		for (Veiculo v : this.veiculos.getVeiculos()) {
			placas.add(v.getPlaca());
		}
		return placas;

	}
}
