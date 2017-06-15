package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;
import java.util.Calendar;

import br.ufsc.ine5605.grupo3.apresentacao.TelaChave;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaChaves;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class ControladorChave {
	private static ControladorChave instance;
	private static ArrayList<Chave> chaves;
	private TelaChaves telaChaves;

	private ControladorChave() {
		this.telaChaves = new TelaChaves();
	}

	public static ControladorChave getInstance() {
		if (instance == null) {
			instance = new ControladorChave();
		}

		return instance;
	}

	public void adicionarChave(String placa) {
		if (this.checkExists(placa) == -1) {
			chaves.add(new Chave(placa));
		}
	}

	public void deletarChave(String placa) {
		int index = this.checkExists(placa);

		if (index != -1) {
			chaves.remove(index);
		}
	}

	public void exibirChaves() {
		int index = 0;
		for (Chave c : chaves) {
//			this.telaChave.exibeTelaExibicao(c, index);
			index++;
		}
	}

	public ArrayList<Chave> getChaves() {
		return chaves;
	}

	public Integer checkExists(String placa) {
		int index = 0;
		for (Chave c : chaves) {
			if (c.getPlaca().equals(placa)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public Chave getChave(String placa) {
		int index = this.checkExists(placa);

		return index != -1 ? chaves.get(index) : null;
	}

	public void exibeTelaChave() {
		telaChaves.setVisible(true);
	}

	public Funcionario pegaFuncionario(int matricula) {
		return ControladorPrincipal.getInstance().pegaFuncionario(matricula);
	}

	public int cederChave(Funcionario f, Chave c) {
		if (f.getBloqueado()) {
			this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f, null,
					false, "Retirada : Usuario Bloqueado");
			return -3;
		}

		if (f.getChave() == null) {
			if (f.getCargo() == Cargo.DIRETORIA || f.checaPlacas(c)) {
				if (c.isAlugada()) {
					this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
							ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Acesso a chave previamente alugada");
					return -4;
				}
				f.setChave(c);
				c.setAlugada(true);
				this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Retirada : Acesso Permitido ao Veiculo");
				return 0;
			} else {
				this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, " Retirada : Funcionario nào possui acesso ao veiculo escolhido");
				return -1;
			}
		} else {
			this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Funcionario já possui uma chave alugada");
			return -2;
		}
	}

	public int devolverChave(Funcionario f, Chave c) {
		if (f.getBloqueado()) {
			this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f, null,
					false, "Retirada : Usuario Bloqueado");
			return -2;
		}

		f.setChave(null);
		c.setAlugada(false);
		this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
				ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Devolucao : Chave devolvida com sucesso");
		return 0;

	}

	public void adicionarRegistro(int date, int mes, int hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorPrincipal.getInstance().adicionarRegistro(date, mes, hours, f, v, b, string);
	}

	public void bloquearFuncionario(Funcionario f) {
		ControladorPrincipal.getInstance().bloquearFuncionario(f);

	}
}
